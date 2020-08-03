package com.iwgdupo.fintech.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum RequestStatus implements EnumClass<String> {

    NEW("A"),
    IN_PROGRESS("B"),
    APPROVED("C"),
    CANCELLED("D"),
    REJECTED("E");

    private String id;

    RequestStatus(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static RequestStatus fromId(String id) {
        for (RequestStatus at : RequestStatus.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}