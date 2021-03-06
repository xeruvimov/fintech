package com.iwgdupo.fintech.service;

import com.google.gson.Gson;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.TimeSource;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.core.sys.AppContext;
import com.haulmont.cuba.security.entity.User;
import com.iwgdupo.fintech.entity.Message;
import com.iwgdupo.fintech.entity.TelegramUser;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
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
    public String receiveMessage(String telegramId, String message, String userType) {
        saveMessage(message, telegramUserService.findOrCreateUser(telegramId, userType));
        return "Ok";
    }

    @Override
    public void sendMessage(TelegramUser msgUser, String message) {
        try {
            TelegramMessagePOJO pojo = new TelegramMessagePOJO();

            pojo.setMessage(message);
            pojo.setTelegramId(msgUser.getMsgId());
            pojo.setUserType(msgUser.getUserType());

            String postUrl = AppContext.getProperty("fintech.bot.ip") + URL_SEND_MSG;
            Gson gson = new Gson();
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost(postUrl);
            StringEntity postingString = new StringEntity(gson.toJson(pojo), StandardCharsets.UTF_8);
            post.setEntity(postingString);
            post.setHeader("Content-type", "application/json; charset=utf-8");
            HttpResponse response = httpClient.execute(post);

            saveMessage(message,
                    msgUser,
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

        try (Transaction transaction = persistence.createTransaction()) {
            persistence.getEntityManager().persist(resultMessage);
            transaction.commit();
        }
    }

    class TelegramMessagePOJO {
        String telegramId;
        String message;
        String userType;

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public String getTelegramId() {
            return telegramId;
        }

        public void setTelegramId(String telegramId) {
            this.telegramId = telegramId;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}