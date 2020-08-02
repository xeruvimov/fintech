package com.iwgdupo.fintech.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Table(name = "FINTECH_TELEGRAM_USER")
@Entity(name = "fintech_TelegramUser")
public class TelegramUser extends StandardEntity {
    private static final long serialVersionUID = -275729742112888873L;

    @Column(name = "TELEGRAM_ID")
    protected String telegramId;

    @OneToMany(mappedBy = "telegramUser")
    protected List<Message> messages;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public String getTelegramId() {
        return telegramId;
    }

    public void setTelegramId(String telegramId) {
        this.telegramId = telegramId;
    }
}