package com.example.core_banking_system.service;

import com.example.core_banking_system.dto.RegisterRequestDto;
import com.example.core_banking_system.entity.Customer;
import com.example.core_banking_system.repository.CustomerRepository;
import com.example.core_banking_system.utils.Crypto;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final Crypto crypto;

    public CustomerService(CustomerRepository customerRepository, Crypto crypto) {
        this.customerRepository = customerRepository;
        this.crypto = crypto;
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        System.out.println("Customers found in service: " + customers.size());
        return customers;
    }

    public Customer registerCustomer(RegisterRequestDto request) {
        if (customerRepository.existsByEmail(request.email)) {
            throw new IllegalArgumentException("Email is already registered.");
        }

        LocalDateTime now = LocalDateTime.now();

        Customer customer = Customer.builder()
            .customerId(UUID.randomUUID().toString())
            .email(request.getEmail())
            .passwordHash(crypto.hash(request.getPassword()))
            .citizenId(request.getCitizenId())
            .thaiName(request.getThaiName())
            .englishName(request.getEnglishName())
            .pinHash(request.getPin())
            .registeredAt(now)
            .createdAt(now)
            .updatedAt(now)
            .build();

        return customerRepository.save(customer);
    }
}
