package com.iwgdupo.fintech.service;

import com.iwgdupo.fintech.entity.TelegramUser;

public interface ChatService {
    String NAME = "fintech_ChatService";

    String receiveMessage(String telegramId, String message, String userType);

    void sendMessage(TelegramUser msgUser, String message);
}