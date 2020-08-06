package com.iwgdupo.fintech.service;

import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.iwgdupo.fintech.entity.CreditCard;
import com.iwgdupo.fintech.entity.DebitCard;
import com.iwgdupo.fintech.entity.MinimalRequestDTO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service(RequestStatusService.NAME)
public class RequestStatusServiceBean implements RequestStatusService {
    @Inject
    protected Persistence persistence;

    @Override
    public List<MinimalRequestDTO> getActiveRequestsByUserId(String id) {
        List<MinimalRequestDTO> result = new ArrayList<>(getActiveDebitCard(id));
        result.addAll(getActiveCreditCard(id));
        return result;
    }

    @Override
    @Deprecated
    public MinimalRequestDTO getRequestById(String id, String type) {
        try (Transaction transaction = persistence.createTransaction()) {
            switch (type) {
                case DebitCard.NAME:
                    return mapDebitCardOnDTO(Objects.requireNonNull(
                            persistence.getEntityManager().find(DebitCard.class, UUID.fromString(id))));
            }
            transaction.commit();
        }
        return null;
    }

    private List<MinimalRequestDTO> getActiveCreditCard(String id) {
        try (Transaction transaction = persistence.createTransaction()) {
            List<CreditCard> debitCardList = persistence.getEntityManager().createQuery("select dc from fintech_CreditCard dc " +
                    "where dc.userMessager.telegramId = :id", CreditCard.class)
                    .setParameter("id", id)
                    .getResultList();
            transaction.commit();
            return debitCardList.stream().map(this::mapCreditCardOnDTO).collect(Collectors.toList());
        }
    }

    private List<MinimalRequestDTO> getActiveDebitCard(String id) {
        try (Transaction transaction = persistence.createTransaction()) {
            List<DebitCard> debitCardList = persistence.getEntityManager().createQuery("select dc from fintech_DebitCard dc " +
                    "where dc.userMessager.telegramId = :id", DebitCard.class)
                    .setParameter("id", id)
                    .getResultList();
            transaction.commit();
            return debitCardList.stream().map(this::mapDebitCardOnDTO).collect(Collectors.toList());
        }
    }

    private MinimalRequestDTO mapCreditCardOnDTO(CreditCard creditCard) {
        MinimalRequestDTO minimalRequestDTO = new MinimalRequestDTO();
        minimalRequestDTO.setId(creditCard.getId());
        minimalRequestDTO.setType(DebitCard.NAME);
        minimalRequestDTO.setStatus(creditCard.getStatus());
        return minimalRequestDTO;
    }

    private MinimalRequestDTO mapDebitCardOnDTO(DebitCard debitCard) {
        MinimalRequestDTO minimalRequestDTO = new MinimalRequestDTO();
        minimalRequestDTO.setId(debitCard.getId());
        minimalRequestDTO.setType(DebitCard.NAME);
        minimalRequestDTO.setStatus(debitCard.getStatus());
        return minimalRequestDTO;
    }
}