package com.iwgdupo.fintech.service;

import com.iwgdupo.fintech.entity.TelegramUser;

public interface TelegramUserService {
    String NAME = "fintech_TelegramUserService";

    TelegramUser findByTelegramId(String id);

    TelegramUser createUser(String telegramId);

    TelegramUser findOrCreateUser(String telegramId);
}