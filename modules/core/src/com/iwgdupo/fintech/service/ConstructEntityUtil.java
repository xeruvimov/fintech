package com.iwgdupo.fintech.service;

import com.haulmont.cuba.core.global.Metadata;
import com.iwgdupo.fintech.entity.Credit;
import com.iwgdupo.fintech.entity.CreditCard;
import com.iwgdupo.fintech.entity.DebitCard;
import com.iwgdupo.fintech.entity.RequestStatus;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class ConstructEntityUtil {
    @Inject
    private Metadata metadata;
    @Inject
    private TelegramUserService telegramUserService;

    public DebitCard constructEntity(DebitCard debitCard, String telegramId, String userType) {
        DebitCard result = metadata.create(DebitCard.class);

        result.setFirstName(debitCard.getFirstName());
        result.setMiddleName(debitCard.getMiddleName());
        result.setLastName(debitCard.getLastName());
        result.setBirthdate(debitCard.getBirthdate());
        result.setPhoneNumber(debitCard.getPhoneNumber());
        result.setEmail(debitCard.getEmail());
        result.setAddress(debitCard.getAddress());
        result.setPassportNumber(debitCard.getPassportNumber());
        result.setPassportSerial(debitCard.getPassportSerial());
        result.setPassportDate(debitCard.getPassportDate());
        result.setPassportOrganization(debitCard.getPassportOrganization());
        result.setUserMessager(telegramUserService.findOrCreateUser(telegramId, userType));

        result.setStatus(RequestStatus.NEW);

        return result;
    }

    public CreditCard constructEntity(CreditCard creditCard, String telegramId, String userType) {
        CreditCard result = metadata.create(CreditCard.class);

        result.setFirstName(creditCard.getFirstName());
        result.setMiddleName(creditCard.getMiddleName());
        result.setLastName(creditCard.getLastName());
        result.setBirthdate(creditCard.getBirthdate());
        result.setPhoneNumber(creditCard.getPhoneNumber());
        result.setEmail(creditCard.getEmail());
        result.setAddress(creditCard.getAddress());
        result.setPassportNumber(creditCard.getPassportNumber());
        result.setPassportSerial(creditCard.getPassportSerial());
        result.setPassportDate(creditCard.getPassportDate());
        result.setPassportOrganization(creditCard.getPassportOrganization());
        result.setUserMessager(telegramUserService.findOrCreateUser(telegramId, userType));

        result.setWorkPlace(creditCard.getWorkPlace());
        result.setWorkExperience(creditCard.getWorkExperience());
        result.setMonthlyIncome(creditCard.getMonthlyIncome());
        result.setEmployerAddress(creditCard.getEmployerAddress());
        result.setEmployerPhoneNumber(creditCard.getEmployerPhoneNumber());
        result.setMaritalStatus(creditCard.getMaritalStatus());

        result.setStatus(RequestStatus.NEW);

        return result;
    }


    public Credit constructEntity(Credit credit, String telegramId, String userType) {
        Credit result = metadata.create(Credit.class);

        result.setFirstName(credit.getFirstName());
        result.setMiddleName(credit.getMiddleName());
        result.setLastName(credit.getLastName());
        result.setBirthdate(credit.getBirthdate());
        result.setPhoneNumber(credit.getPhoneNumber());
        result.setEmail(credit.getEmail());
        result.setAddress(credit.getAddress());
        result.setPassportNumber(credit.getPassportNumber());
        result.setPassportSerial(credit.getPassportSerial());
        result.setPassportDate(credit.getPassportDate());
        result.setPassportOrganization(credit.getPassportOrganization());
        result.setUserMessager(telegramUserService.findOrCreateUser(telegramId, userType));

        result.setWorkPlace(credit.getWorkPlace());
        result.setWorkExperience(credit.getWorkExperience());
        result.setMonthlyIncome(credit.getMonthlyIncome());
        result.setEmployerAddress(credit.getEmployerAddress());
        result.setEmployerPhoneNumber(credit.getEmployerPhoneNumber());
        result.setMaritalStatus(credit.getMaritalStatus());

        result.setStatus(RequestStatus.NEW);

        return result;
    }
}
