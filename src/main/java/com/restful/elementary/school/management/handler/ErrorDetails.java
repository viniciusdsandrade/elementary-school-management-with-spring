package com.restful.elementary.school.management.handler;

import org.springframework.validation.FieldError;

import java.time.LocalDateTime;

public record ErrorDetails(
        LocalDateTime timestamp,
        String field,
        String details,
        String error) {
}