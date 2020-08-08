package com.iwgdupo.fintech.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.PublishEntityChangedEvents;

import javax.persistence.*;
import java.util.Date;

@PublishEntityChangedEvents
@NamePattern("%s|firstName")
@Table(name = "FINTECH_DEBIT_CARD")
@Entity(name = "fintech_DebitCard")
public class DebitCard extends StandardEntity {
    private static final long serialVersionUID = 3549666836285502815L;
    public static final String NAME = "DebitCard";

    @Column(name = "FIRST_NAME")
    protected String firstName;

    @Column(name = "MIDDLE_NAME")
    protected String middleName;

    @Column(name = "LAST_NAME")
    protected String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTHDAY")
    protected Date birthdate;

    @Column(name = "PHONE_NUMBER")
    protected String phoneNumber;

    @Column(name = "EMAIL")
    protected String email;

    @Column(name = "ADDRESS")
    protected String address;

    @Column(name = "PASSPORT_NUMBER", length = 6)
    protected String passportNumber;

    @Column(name = "PASSPORT_SERIAL", length = 4)
    protected String passportSerial;

    @Temporal(TemporalType.DATE)
    @Column(name = "PASSPORT_DATE")
    protected Date passportDate;

    @Column(name = "PASSPORT_ORGANISATION")
    protected String passportOrganization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TELEGRAM_USER_ID")
    protected TelegramUser userMessager;
    @Column(name = "TYPE_")
    protected String type;

    @Column(name = "STATUS")
    private String status;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public RequestStatus getStatus() {
        return status == null ? null : RequestStatus.fromId(status);
    }

    public void setStatus(RequestStatus status) {
        this.status = status == null ? null : status.getId();
    }

    public TelegramUser getUserMessager() {
        return userMessager;
    }

    public void setUserMessager(TelegramUser userMessager) {
        this.userMessager = userMessager;
    }

    public String getPassportOrganization() {
        return passportOrganization;
    }

    public void setPassportOrganization(String passportOrganization) {
        this.passportOrganization = passportOrganization;
    }

    public Date getPassportDate() {
        return passportDate;
    }

    public void setPassportDate(Date passportDate) {
        this.passportDate = passportDate;
    }

    public String getPassportSerial() {
        return passportSerial;
    }

    public void setPassportSerial(String passportSerial) {
        this.passportSerial = passportSerial;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}