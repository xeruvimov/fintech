package com.iwgdupo.fintech.listeners;

import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.TransactionalDataManager;
import com.haulmont.cuba.core.app.events.AttributeChanges;
import com.haulmont.cuba.core.app.events.EntityChangedEvent;
import com.iwgdupo.fintech.entity.Credit;
import com.iwgdupo.fintech.entity.RequestStatus;
import com.iwgdupo.fintech.entity.TelegramUser;
import com.iwgdupo.fintech.service.ChatService;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.inject.Inject;
import java.util.UUID;

@Component("fintech_CreditChangedListener")
public class CreditChangedListener {
    @Inject
    private Logger log;
    @Inject
    private Persistence persistence;
    @Inject
    private TransactionalDataManager txDm;
    @Inject
    private ChatService chatService;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void afterCommit(EntityChangedEvent<Credit, UUID> event) {
        if (event.getType().equals(EntityChangedEvent.Type.UPDATED)) {
            AttributeChanges changes = event.getChanges();

            if (changes.isChanged("status")) {
                Credit credit = txDm.load(event.getEntityId()).view("credit-view").one();

                String text = "Статус вашей заявки по " + Credit.NAME + " изменился на " + credit.getStatus();

                TelegramUser userMessager = credit.getUserMessager();
                log.debug("Try send notification about status update to [" + userMessager.getMsgId() + "] "
                        + userMessager.getUserType());
                chatService.sendMessage(userMessager, text);

                if (credit.getStatus().equals(RequestStatus.APPROVED)) {
                    if (userMessager.getName() == null)
                        userMessager.setName(credit.getFirstName());
                    if (userMessager.getLastName() == null)
                        userMessager.setLastName(credit.getLastName());
                    persistence.createTransaction().execute(em -> {
                        return em.merge(userMessager);
                    });
                }
            }
        }

    }
}