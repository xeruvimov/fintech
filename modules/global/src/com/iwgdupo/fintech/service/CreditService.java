package com.iwgdupo.fintech.service;

import com.iwgdupo.fintech.entity.Credit;

import java.util.UUID;

public interface CreditService {
    String NAME = "fintech_CreditService";

    UUID createCreditRequest(Credit credit, String telegramId, String userType);

    Credit mergeCreditById(Credit credit);
}