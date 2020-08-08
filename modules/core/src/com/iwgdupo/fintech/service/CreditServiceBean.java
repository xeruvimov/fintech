package com.iwgdupo.fintech.service;

import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.iwgdupo.fintech.entity.Credit;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.UUID;

@Service(CreditService.NAME)
public class CreditServiceBean implements CreditService {
    @Inject
    private Persistence persistence;
    @Inject
    private ConstructEntityUtil constructEntityUtil;

    @Override
    public UUID createCreditRequest(Credit credit, String telegramId, String userType) {
        try (Transaction transaction = persistence.createTransaction()) {
            Credit entity = constructEntityUtil.constructEntity(credit, telegramId, userType);
            persistence.getEntityManager().persist(entity);
            transaction.commit();
            return entity.getId();
        }
    }

    @Override
    public Credit mergeCreditById(Credit credit) {
        try (Transaction transaction = persistence.createTransaction()) {
            Credit result = persistence.getEntityManager().merge(credit);
            transaction.commit();
            return result;
        }
    }
}