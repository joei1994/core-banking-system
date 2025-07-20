package com.example.core_banking_system.service;

import com.example.core_banking_system.dto.CreateAccountDto;
import com.example.core_banking_system.entity.Account;
import com.example.core_banking_system.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public Account createAccount(CreateAccountDto dto) {
        Account account = Account.builder()
            .accountId(UUID.randomUUID().toString())
            .accountNumber(String.format("%07d", new Random().nextInt(10_000_000)))
            .customerId(dto.getCustomerId())
            .balance(dto.getBalance())
            .accountType(dto.getAccountType())
            .status("ACTIVE")
            .createdAt(LocalDateTime.now())
            .createdBy(dto.getCreatedBy())
            .updatedAt(LocalDateTime.now())
            .build();

        return accountRepository.save(account);
    }
}
