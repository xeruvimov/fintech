package com.iwgdupo.fintech.service;

import com.haulmont.cuba.core.Persistence;
import com.iwgdupo.fintech.entity.TelegramUser;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service(AdsService.NAME)
public class AdsServiceBean implements AdsService {
    private static final String MESSAGE = "Это наше рекламное сообщение";

    @Inject
    private ChatService chatService;
    @Inject
    private Persistence persistence;
    @Inject
    private Logger log;

    @Override
    public void sendAdsToAll() {
        List<TelegramUser> telegramUsers = persistence.createTransaction().execute(em -> {
            return em.createQuery("select u from fintech_TelegramUser u",
                    TelegramUser.class)
                    .setViewName("_local")
                    .getResultList();
        });

        for (TelegramUser telegramUser : telegramUsers) {
            try {
                log.debug("Try send ads to ["  + telegramUser.getMsgId() + "]");
                chatService.sendMessage(telegramUser, MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}