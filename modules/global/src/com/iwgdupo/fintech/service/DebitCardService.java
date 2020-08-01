package com.iwgdupo.fintech.service;

import com.iwgdupo.fintech.entity.DebitCard;

public interface DebitCardService {
    String NAME = "fintech_DebitCardService";

    void createDebitCardRequest(DebitCard debitCard);
}