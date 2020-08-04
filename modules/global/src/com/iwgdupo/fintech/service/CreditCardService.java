package com.iwgdupo.fintech.service;

import com.iwgdupo.fintech.entity.CreditCard;

import java.util.UUID;

public interface CreditCardService {
    String NAME = "fintech_CreditCardService";

    UUID createCreditCardRequest(CreditCard creditCard, String telegramId);
}