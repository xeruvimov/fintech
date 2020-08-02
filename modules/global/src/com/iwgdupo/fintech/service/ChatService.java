package com.iwgdupo.fintech.service;

public interface ChatService {
    String NAME = "fintech_ChatService";

    String receiveMessage(String telegramId, String message);

    void sendMessage(String telegramId, String message);
}