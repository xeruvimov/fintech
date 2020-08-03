package com.iwgdupo.fintech.entity;

import java.util.UUID;

public class MinimalRequestDTO {
    private UUID id;
    private String type;
    private RequestStatus status;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }
}
