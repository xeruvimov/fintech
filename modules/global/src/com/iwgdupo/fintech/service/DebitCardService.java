package com.iwgdupo.fintech.service;

import com.iwgdupo.fintech.entity.DebitCard;

import java.util.UUID;

public interface DebitCardService {
    String NAME = "fintech_DebitCardService";

    UUID createDebitCardRequest(DebitCard debitCard, String telegramId);
}