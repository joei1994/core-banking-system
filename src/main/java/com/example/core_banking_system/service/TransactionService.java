package com.example.core_banking_system.service;

import com.example.core_banking_system.dto.DepositDto;
import com.example.core_banking_system.dto.TransferDto;
import com.example.core_banking_system.dto.WithdrawDto;
import com.example.core_banking_system.entity.Account;
import com.example.core_banking_system.entity.Customer;
import com.example.core_banking_system.entity.Transaction;
import com.example.core_banking_system.repository.AccountRepository;
import com.example.core_banking_system.repository.CustomerRepository;
import com.example.core_banking_system.repository.TransactionRepository;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public Transaction transfer(String customerId, TransferDto dto) {
        if (dto.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Transfer amount must be positive");
        }

        Customer customer = customerRepository.findById(customerId)
            .orElseThrow(() -> new RuntimeException("Customer not found"));                

        Account sourceAccount = accountRepository.findByIdForUpdate(dto.sourceAccount)
            .orElseThrow(() -> new RuntimeException("Source account not found"));

        if (!customer.getCustomerId().equals(sourceAccount.getCustomerId())) {
            throw new IllegalArgumentException("You do not own the source account");
        }

        Account targetAccount = accountRepository.findByIdForUpdate(dto.getTargetAccount())
            .orElseThrow(() -> new RuntimeException("Destination account not found"));

        if (sourceAccount.getAccountId().equals(targetAccount.getAccountId())) {
            throw new IllegalArgumentException("Cannot transfer to the same account");
        }

        if (sourceAccount.getBalance().compareTo(dto.getAmount()) < 0) {
            throw new IllegalArgumentException("Insufficient balance to transfer");
        }

        // Debit from source account
        sourceAccount.setBalance(sourceAccount.getBalance().subtract(dto.getAmount()));
        // Credit to source account
        targetAccount.setBalance(targetAccount.getBalance().add(dto.getAmount()));

        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);

        Transaction transaction = Transaction.builder()
            .transactionId(UUID.randomUUID().toString())
            .accountId(sourceAccount.getAccountId())
            .amount(dto.getAmount())
            .transactionType("TRANSFER")
            .referenceAccount(targetAccount.getAccountId())
            .timestamp(LocalDateTime.now())
            .performedBy(sourceAccount.getAccountId())
            .status("SUCCESS")
            .build();

        return transactionRepository.save(transaction);
    }

    @Transactional
    public Transaction deposit(DepositDto dto) {
        if (dto.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }

        Account account = accountRepository.findByIdForUpdate(dto.getAccountId())
            .orElseThrow(() -> new RuntimeException("Account not found"));

        account.setBalance(account.getBalance().add(dto.getAmount()));
        accountRepository.save(account);

        return saveTransaction(dto.getAccountId(), dto.getAmount(), "DEPOSIT", dto.getTellerId());
    }

    @Transactional
    public Transaction withdraw(WithdrawDto dto) {
        if (dto.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }

        Account account = accountRepository.findByIdForUpdate(dto.getAccountId())
            .orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getBalance().compareTo(dto.getAmount()) < 0) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        account.setBalance(account.getBalance().subtract(dto.getAmount()));
        accountRepository.save(account);

        return saveTransaction(dto.getAccountId(), dto.getAmount(), "WITHDRAW", dto.getTellerId());
    }

    private Transaction saveTransaction(String accountId, BigDecimal amount, String type, String performedBy) {
        return transactionRepository.save(
            Transaction.builder()
                .transactionId(UUID.randomUUID().toString())
                .accountId(accountId)
                .amount(amount)
                .transactionType(type)
                .timestamp(LocalDateTime.now())
                .performedBy(performedBy)
                .status("SUCCESS")
                .build()
        );
    }
}
