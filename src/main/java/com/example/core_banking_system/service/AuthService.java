package com.example.core_banking_system.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.core_banking_system.dto.LoginRequestDto;
import com.example.core_banking_system.dto.LoginResponseDto;
import com.example.core_banking_system.entity.Customer;
import com.example.core_banking_system.repository.CustomerRepository;
import com.example.core_banking_system.utils.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final CustomerRepository customerRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public LoginResponseDto login(LoginRequestDto request) {
        Customer customer = customerRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

        if (!passwordEncoder.matches(request.getPassword(), customer.getPasswordHash())) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        String token = jwtUtil.generateToken(customer.getCustomerId());
        return new LoginResponseDto(token);
    }
}

