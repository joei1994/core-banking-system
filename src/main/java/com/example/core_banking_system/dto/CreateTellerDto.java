package com.example.core_banking_system.dto;

import lombok.Data;

@Data
public class CreateTellerDto {
    public String email;
    public String password;
    public String thaiName;
    public String englishName;
}
