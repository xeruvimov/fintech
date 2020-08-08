package com.iwgdupo.fintech.listeners;

import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.TransactionalDataManager;
import com.haulmont.cuba.core.app.events.AttributeChanges;
import com.haulmont.cuba.core.app.events.EntityChangedEvent;
import com.iwgdupo.fintech.entity.DebitCard;
import com.iwgdupo.fintech.entity.RequestStatus;
import com.iwgdupo.fintech.entity.TelegramUser;
import com.iwgdupo.fintech.service.ChatService;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.inject.Inject;
import java.util.UUID;

@Component("fintech_DebitCardChangedListener")
public class DebitCardChangedListener {
    @Inject
    private Logger log;
    @Inject
    private Persistence persistence;
    @Inject
    private TransactionalDataManager txDm;
    @Inject
    private ChatService chatService;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void afterCommit(EntityChangedEvent<DebitCard, UUID> event) {
        if (event.getType().equals(EntityChangedEvent.Type.UPDATED)) {
            AttributeChanges changes = event.getChanges();

            if (changes.isChanged("status")) {
                DebitCard debitCard = txDm.load(event.getEntityId()).view("debitCard-view").one();

                String text = "Статус вашей заявки по " + DebitCard.NAME + " изменился на " + debitCard.getStatus();

                TelegramUser userMessager = debitCard.getUserMessager();
                log.debug("Try send notification about status update to [" + userMessager.getMsgId() + "] "
                        + userMessager.getUserType());
                chatService.sendMessage(userMessager, text);

                if (debitCard.getStatus().equals(RequestStatus.APPROVED)) {
                    if (userMessager.getName() == null)
                        userMessager.setName(debitCard.getFirstName());
                    if (userMessager.getLastName() == null)
                        userMessager.setLastName(debitCard.getLastName());
                    persistence.createTransaction().execute(em -> {
                        return em.merge(userMessager);
                    });
                }
            }
        }
    }
}