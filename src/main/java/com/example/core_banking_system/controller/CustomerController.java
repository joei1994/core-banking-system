package com.example.core_banking_system.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.core_banking_system.dto.ErrorResponseDto;
import com.example.core_banking_system.dto.LoginRequestDto;
import com.example.core_banking_system.dto.LoginResponseDto;
import com.example.core_banking_system.dto.RegisterRequestDto;
import com.example.core_banking_system.dto.TransferDto;
import com.example.core_banking_system.entity.Customer;
import com.example.core_banking_system.entity.Transaction;
import com.example.core_banking_system.service.AuthService;
import com.example.core_banking_system.service.CustomerService;
import com.example.core_banking_system.service.TransactionService;
import com.example.core_banking_system.utils.JwtUtil;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final AuthService authService;
    private final TransactionService transactionService;
    private final JwtUtil jwtUtil;

    public CustomerController(CustomerService customerService, AuthService authService, TransactionService transactionService, JwtUtil jwtUtil) {
        this.customerService = customerService;
        this.authService = authService;
        this.transactionService = transactionService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/register")
    public Customer registerCustomer(@RequestBody RegisterRequestDto request) {
        return customerService.registerCustomer(request);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/transfer")
    public ResponseEntity<Transaction> transfer(
            @RequestHeader("Authorization") String authHeader,
            @RequestBody TransferDto request) {

        String token = authHeader.replace("Bearer ", "");
        String customerId = jwtUtil.extractSubject(token);

        return ResponseEntity.ok(transactionService.transfer(customerId, request));
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