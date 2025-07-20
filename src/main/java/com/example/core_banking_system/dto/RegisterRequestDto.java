package com.example.core_banking_system.dto;

import lombok.Data;

@Data
public class RegisterRequestDto {
    public String email;
    public String password;
    public String citizenId;
    public String thaiName;
    public String englishName;
    public Integer pin;
}
