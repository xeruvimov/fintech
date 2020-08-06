package com.iwgdupo.fintech.entity;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.cuba.core.entity.BaseUuidEntity;

@MetaClass(name = "fintech_MinimalRequestDTO")
public class MinimalRequestDTO extends BaseUuidEntity {
    private static final long serialVersionUID = -8052890944088777211L;

    @MetaProperty
    protected String type;

    @MetaProperty
    protected String status;

    public RequestStatus getStatus() {
        return status == null ? null : RequestStatus.fromId(status);
    }

    public void setStatus(RequestStatus status) {
        this.status = status == null ? null : status.getId();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}