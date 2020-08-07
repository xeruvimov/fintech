package com.iwgdupo.fintech.service;

import com.iwgdupo.fintech.entity.TelegramUser;

public interface TelegramUserService {
    String NAME = "fintech_TelegramUserService";

    TelegramUser findByTelegramId(String id, String userType);

    TelegramUser createUser(String telegramId, String userType);

    TelegramUser findOrCreateUser(String telegramId, String userType);
}