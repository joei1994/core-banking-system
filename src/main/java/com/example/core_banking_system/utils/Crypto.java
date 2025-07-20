package com.example.core_banking_system.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Crypto {
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String hash(String raw) {
        return passwordEncoder.encode(raw);
    }
}
