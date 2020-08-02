package com.iwgdupo.fintech.service;

import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.TimeSource;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.core.sys.AppContext;
import com.haulmont.cuba.security.entity.User;
import com.iwgdupo.fintech.entity.Message;
import com.iwgdupo.fintech.entity.TelegramUser;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Service(ChatService.NAME)
public class ChatServiceBean implements ChatService {
    private static final String URL_SEND_MSG = "/api/message/send";

    @Inject
    private TelegramUserService telegramUserService;
    @Inject
    private Metadata metadata;
    @Inject
    private Persistence persistence;
    @Inject
    private TimeSource timeSource;
    @Inject
    private UserSessionSource userSessionSource;

    @Override
    public void receiveMessage(String telegramId, String message) {
        saveMessage(message, telegramUserService.findOrCreateUser(telegramId));
    }

    @Override
    public void sendMessage(String telegramId, String message) {
        HttpURLConnection connection;

        try {
            URL url = new URL(AppContext.getProperty("fintech.bot.ip") + URL_SEND_MSG);

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            String jsonToSend = "{ \"telegramId\": " + telegramId + ", \"message\": " + message + " }";

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonToSend.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response.toString());
            }

            saveMessage(message,
                    telegramUserService.findOrCreateUser(telegramId),
                    userSessionSource.getUserSession().getCurrentOrSubstitutedUser());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveMessage(String message, TelegramUser telegramUser) {
        saveMessage(message, telegramUser, null);
    }

    private void saveMessage(String message, TelegramUser telegramUser, User cubaUser) {
        Message resultMessage = metadata.create(Message.class);

        resultMessage.setTelegramUser(telegramUser);
        resultMessage.setText(message);
        resultMessage.setDatetime(timeSource.currentTimestamp());
        resultMessage.setCubaUser(cubaUser);

        try (Transaction ignored = persistence.createTransaction()) {
            persistence.getEntityManager().persist(resultMessage);
        }
    }
}