package com.example.core_banking_system.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferDto {
    public String sourceAccount;
    public BigDecimal amount;
    public String targetAccount;
}
