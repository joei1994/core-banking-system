package com.example.core_banking_system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.core_banking_system.dto.CreateAccountDto;
import com.example.core_banking_system.dto.CreateTellerDto;
import com.example.core_banking_system.dto.DepositDto;
import com.example.core_banking_system.dto.ErrorResponseDto;
import com.example.core_banking_system.dto.WithdrawDto;
import com.example.core_banking_system.entity.Account;
import com.example.core_banking_system.entity.Teller;
import com.example.core_banking_system.entity.Transaction;
import com.example.core_banking_system.service.AccountService;
import com.example.core_banking_system.service.TellerService;
import com.example.core_banking_system.service.TransactionService;

@RestController
@RequestMapping("/tellers")
public class TellerController {

    private final TellerService tellerService;
    private final AccountService accountService;
    private final TransactionService transactionService;

    public TellerController(TellerService tellerService, AccountService accountService, TransactionService transactionService) {
        this.tellerService = tellerService;
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Teller> createTeller(@RequestBody CreateTellerDto tellerDto) {
        return ResponseEntity.ok(tellerService.createTeller(tellerDto));
    }

    @PostMapping("/account")
    public ResponseEntity<Account> createAccount(@RequestBody CreateAccountDto dto) {
        Account account = accountService.createAccount(dto);
        return ResponseEntity.ok(account);
    }

    @PostMapping("/deposit")
    public ResponseEntity<Transaction> deposit(@RequestBody DepositDto dto) {
        return ResponseEntity.ok(transactionService.deposit(dto));
    }

    @PostMapping("/withdraw")
    public ResponseEntity<Transaction> withdraw(@RequestBody WithdrawDto dto) {
        return ResponseEntity.ok(transactionService.withdraw(dto));
    }    

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponseDto> handleIllegalArgument(IllegalArgumentException ex) {
        ErrorResponseDto errorResponse = new ErrorResponseDto(
            "Bad Request",
            ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
