package com.iwgdupo.fintech.service;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.global.Metadata;
import com.iwgdupo.fintech.entity.DebitCard;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.UUID;

@Service(DebitCardService.NAME)
public class DebitCardServiceBean implements DebitCardService {
    @Inject
    private TelegramUserService telegramUserService;
    @Inject
    private Persistence persistence;
    @Inject
    private Metadata metadata;

    @Override
    public UUID createDebitCardRequest(DebitCard debitCard, String telegramId) {
        try(Transaction transaction = persistence.createTransaction()) {
            DebitCard entity = constructEntity(debitCard, telegramId);
            persistence.getEntityManager().persist(entity);
            transaction.commit();
            return entity.getId();
        }
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