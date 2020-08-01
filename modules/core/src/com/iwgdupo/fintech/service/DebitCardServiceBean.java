package com.iwgdupo.fintech.service;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.global.Metadata;
import com.iwgdupo.fintech.entity.DebitCard;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(DebitCardService.NAME)
public class DebitCardServiceBean implements DebitCardService {
    @Inject
    private Persistence persistence;
    @Inject
    private Metadata metadata;

    @Override
    public void createDebitCardRequest(DebitCard debitCard) {
        Transaction transaction = persistence.createTransaction();
        EntityManager entityManager = persistence.getEntityManager();
        try {
            entityManager.persist(constructEntity(debitCard));
            transaction.commit();
        } finally {
            transaction.end();
        }
    }

    private DebitCard constructEntity(DebitCard debitCard) {
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
        result.setPassportOrganisation(debitCard.getPassportOrganisation());
        result.setTelegrammId(result.getTelegrammId());

        return result;
    }
}