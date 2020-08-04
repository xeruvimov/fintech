package com.iwgdupo.fintech.service;

import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.iwgdupo.fintech.entity.CreditCard;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.UUID;

@Service(CreditCardService.NAME)
public class CreditCardServiceBean implements CreditCardService {
    @Inject
    private Persistence persistence;
    @Inject
    private ConstructEntityUtil constructEntityUtil;


    @Override
    public UUID createCreditCardRequest(CreditCard creditCard, String telegramId) {
        try (Transaction transaction = persistence.createTransaction()) {
            CreditCard entity = constructEntityUtil.constructEntity(creditCard, telegramId);
            persistence.getEntityManager().persist(entity);
            transaction.commit();
            return entity.getId();
        }
    }
}