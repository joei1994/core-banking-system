package com.example.core_banking_system.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateAccountDto {
    public String customerId;
    public BigDecimal balance;
    public String accountType;
    public String createdBy;
}
