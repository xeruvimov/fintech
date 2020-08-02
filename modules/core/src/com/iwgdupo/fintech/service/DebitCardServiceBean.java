package com.iwgdupo.fintech.service;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.global.Metadata;
import com.iwgdupo.fintech.entity.DebitCard;
import com.iwgdupo.fintech.entity.TelegramUser;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(DebitCardService.NAME)
public class DebitCardServiceBean implements DebitCardService {
    @Inject
    private TelegramUserService telegramUserService;
    @Inject
    private Persistence persistence;
    @Inject
    private Metadata metadata;

    @Override
    public String createDebitCardRequest(DebitCard debitCard, String telegramId) {
        Transaction transaction = persistence.createTransaction();
        EntityManager entityManager = persistence.getEntityManager();
        try {
            entityManager.persist(constructEntity(debitCard, telegramId));
            transaction.commit();
        } finally {
            transaction.end();
        }
        return "zbs";
    }

    private DebitCard constructEntity(DebitCard debitCard, String telegramId) {
        DebitCard result = metadata.create(DebitCard.class);

        result.setFirstName(debitCard.getFirstName());
        result.setMiddleName(debitCard.getMiddleName());
        result.setLastName(debitCard.getLastName());
        result.setBirthday(debitCard.getBirthday());
        result.setPhoneNumber(debitCard.getPhoneNumber());
        result.setEmail(debitCard.getEmail());
        result.setAddress(debitCard.getAddress());
        result.setPassportNumber(debitCard.getPassportNumber());
        result.setPassportSerial(debitCard.getPassportSerial());
        result.setPassportDate(debitCard.getPassportDate());
        result.setPassportOrganization(debitCard.getPassportOrganization());
        result.setTelegramUser(telegramUserService.findOrCreateUser(telegramId));

        return result;
    }
}