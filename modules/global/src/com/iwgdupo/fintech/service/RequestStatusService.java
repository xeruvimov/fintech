package com.iwgdupo.fintech.service;

import com.iwgdupo.fintech.entity.MinimalRequestDTO;

import java.util.List;

public interface RequestStatusService {
    String NAME = "fintech_RequestStatusService";

    List<MinimalRequestDTO> getActiveRequestsByUserId(String id);

    MinimalRequestDTO getRequestById(String id, String type);
}