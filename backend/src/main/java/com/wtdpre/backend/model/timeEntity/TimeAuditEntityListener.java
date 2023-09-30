package com.wtdpre.backend.model.timeEntity;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class TimeAuditEntityListener {

    @PrePersist
    public void prevInsert(Object obj) {
        if(obj instanceof TimeAuditable) ((TimeAuditable) obj).setCreatedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void prevUpdate(Object obj) {
        if(obj instanceof TimeAuditable) ((TimeAuditable) obj).setUpdatedAt(LocalDateTime.now());
    }
}
