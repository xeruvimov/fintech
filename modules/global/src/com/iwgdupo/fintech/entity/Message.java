package com.iwgdupo.fintech.entity;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;
import java.util.Date;

@Table(name = "FINTECH_MESSAGE")
@Entity(name = "fintech_Message")
public class Message extends StandardEntity {
    private static final long serialVersionUID = -5595927445983501369L;

    @Lob
    @Column(name = "TEXT")
    protected String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUBA_USER_ID")
    protected User cubaUser;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATETIME")
    protected Date datetime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TELEGRAM_USER_ID")
    protected TelegramUser telegramUser;

    public User getCubaUser() {
        return cubaUser;
    }

    public void setCubaUser(User cubaUser) {
        this.cubaUser = cubaUser;
    }

    public TelegramUser getTelegramUser() {
        return telegramUser;
    }

    public void setTelegramUser(TelegramUser telegramUser) {
        this.telegramUser = telegramUser;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}