package com.iwgdupo.fintech.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.util.List;

@NamePattern("%s %s %s|name,lastName,msgId")
@Table(name = "FINTECH_TELEGRAM_USER")
@Entity(name = "fintech_TelegramUser")
public class TelegramUser extends StandardEntity {
    private static final long serialVersionUID = -275729742112888873L;

    @Column(name = "TELEGRAM_ID")
    protected String msgId;

    @OrderBy("datetime")
    @OneToMany(mappedBy = "telegramUser")
    protected List<Message> messages;

    @Column(name = "USER_TYPE")
    protected String userType;

    @Column(name = "NAME")
    protected String name;

    @Column(name = "LAST_NAME")
    protected String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}