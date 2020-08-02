package com.iwgdupo.fintech.service;

import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.global.Metadata;
import com.iwgdupo.fintech.entity.TelegramUser;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(TelegramUserService.NAME)
public class TelegramUserServiceBean implements TelegramUserService {
    @Inject
    private Persistence persistence;
    @Inject
    private Metadata metadata;

    @Override
    public TelegramUser findByTelegramId(String id) {
        try (Transaction transaction = persistence.createTransaction()) {
            TelegramUser result = persistence
                    .getEntityManager()
                    .createQuery("select u from fintech_TelegramUser u where u.telegramId = :tlgId",
                            TelegramUser.class)
                    .setParameter("tlgId", id)
                    .setViewName("_local")
                    .getFirstResult();
            transaction.commit();
            return result;
        }
    }

    @Override
    public TelegramUser createUser(String telegramId) {
        TelegramUser telegramUser = metadata.create(TelegramUser.class);

        telegramUser.setTelegramId(telegramId);

        try (Transaction transaction = persistence.createTransaction()) {
            persistence.getEntityManager().persist(telegramUser);
            transaction.commit();
        }

        return telegramUser;
    }

    @Override
    public TelegramUser findOrCreateUser(String telegramId) {
        TelegramUser telegramUser = findByTelegramId(telegramId);
        if (telegramUser == null) {
            telegramUser = createUser(telegramId);
        }
        return telegramUser;
    }
}