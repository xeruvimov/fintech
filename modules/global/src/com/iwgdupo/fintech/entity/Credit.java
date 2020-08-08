package com.iwgdupo.fintech.entity;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.PublishEntityChangedEvents;

import javax.persistence.*;
import java.util.Date;

@PublishEntityChangedEvents
@Table(name = "FINTECH_CREDIT")
@Entity(name = "fintech_Credit")
public class Credit extends StandardEntity {
    public static final String NAME = "Credit";
    private static final long serialVersionUID = -6865318037313730823L;
    @Column(name = "TYPE_")
    protected String type;
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
    @Column(name = "STATUS")
    protected String status;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "WORK_PLACE")
    private String workPlace;
    @Column(name = "WORK_EXPERIENCE")
    private String workExperience;
    @Column(name = "MONTHLY_INCOME")
    private String monthlyIncome;
    @Column(name = "EMPLOYER_ADDRESS")
    private String employerAddress;
    @Column(name = "EMPLOYER_PHONE_NUMBER")
    private String employerPhoneNumber;
    @Column(name = "MARITAL_STATUS")
    private String maritalStatus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_MESSAGER_ID")
    private TelegramUser userMessager;

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

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPassportSerial() {
        return passportSerial;
    }

    public void setPassportSerial(String passportSerial) {
        this.passportSerial = passportSerial;
    }

    public Date getPassportDate() {
        return passportDate;
    }

    public void setPassportDate(Date passportDate) {
        this.passportDate = passportDate;
    }

    public String getPassportOrganization() {
        return passportOrganization;
    }

    public void setPassportOrganization(String passportOrganization) {
        this.passportOrganization = passportOrganization;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public String getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(String monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public String getEmployerAddress() {
        return employerAddress;
    }

    public void setEmployerAddress(String employerAddress) {
        this.employerAddress = employerAddress;
    }

    public String getEmployerPhoneNumber() {
        return employerPhoneNumber;
    }

    public void setEmployerPhoneNumber(String employerPhoneNumber) {
        this.employerPhoneNumber = employerPhoneNumber;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public TelegramUser getUserMessager() {
        return userMessager;
    }

    public void setUserMessager(TelegramUser userMessager) {
        this.userMessager = userMessager;
    }
}