package com.bali.missioncontrol.exception;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public record ApiError(
        OffsetDateTime timestamp,
        int status,
        String error,
        String message,
        String path
) {
}
