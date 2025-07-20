package com.example.core_banking_system.dto;

import lombok.Data;

@Data
public class ErrorResponseDto {
    private String error;
    private String message;
    private long timestamp;

    public ErrorResponseDto(String error, String message) {
        this.error = error;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }
}

