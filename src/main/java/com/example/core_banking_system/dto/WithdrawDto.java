package com.example.core_banking_system.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WithdrawDto {
    public String tellerId;
    public String accountId;
    public BigDecimal amount;
}
