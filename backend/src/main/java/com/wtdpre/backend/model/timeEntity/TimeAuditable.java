package com.wtdpre.backend.model.timeEntity;

import java.time.LocalDateTime;

public interface TimeAuditable {

    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();

    void setCreatedAt(LocalDateTime createdAt);
    void setUpdatedAt(LocalDateTime updatedAt);
}
