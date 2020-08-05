package com.iwgdupo.fintech.service;

import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.iwgdupo.fintech.entity.DebitCard;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.UUID;

@Service(DebitCardService.NAME)
public class DebitCardServiceBean implements DebitCardService {
    @Inject
    private Persistence persistence;
    @Inject
    private ConstructEntityUtil constructEntityUtil;

    @Override
    public UUID createDebitCardRequest(DebitCard debitCard, String telegramId) {
        try (Transaction transaction = persistence.createTransaction()) {
            DebitCard entity = constructEntityUtil.constructEntity(debitCard, telegramId);
            persistence.getEntityManager().persist(entity);
            transaction.commit();
            return entity.getId();
        }
    }

    @Override
    public DebitCard mergeDebitCardById(DebitCard debitCard) {
        try (Transaction transaction = persistence.createTransaction()) {
            DebitCard result = persistence.getEntityManager().merge(debitCard);
            transaction.commit();
            return result;
        }
    }
}