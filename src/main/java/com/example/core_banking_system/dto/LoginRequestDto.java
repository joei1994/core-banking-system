package com.example.core_banking_system.dto;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String email;
    private String password;
}

