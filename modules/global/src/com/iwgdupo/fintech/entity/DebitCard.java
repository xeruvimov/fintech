package com.iwgdupo.fintech.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.util.Date;

@NamePattern("%s|firstName")
@Table(name = "FINTECH_DEBIT_CARD")
@Entity(name = "fintech_DebitCard")
public class DebitCard extends StandardEntity {
    private static final long serialVersionUID = 3549666836285502815L;

    @Column(name = "FIRST_NAME")
    protected String firstName;

    @Column(name = "MIDDLE_NAME")
    protected String middleName;

    @Column(name = "LAST_NAME")
    protected String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTHDAY")
    protected Date birthday;

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

    @Column(name = "TELEGRAMM_ID")
    protected String telegramId;

    public String getTelegramId() {
        return telegramId;
    }

    public void setTelegramId(String telegramId) {
        this.telegramId = telegramId;
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

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return birthday;
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