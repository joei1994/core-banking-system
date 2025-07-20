package com.example.core_banking_system.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.core_banking_system.dto.CreateTellerDto;
import com.example.core_banking_system.entity.Teller;
import com.example.core_banking_system.repository.TellerRepository;
import com.example.core_banking_system.utils.Crypto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class TellerService {

    private final TellerRepository tellerRepository;
    private final Crypto crypto;

    public TellerService(TellerRepository tellerRepository, Crypto crypto) {
        this.tellerRepository = tellerRepository;
        this.crypto = crypto;
    }

    public List<Teller> getAllTellers() {
        return tellerRepository.findAll();
    }

    public Optional<Teller> getTellerById(String userId) {
        return tellerRepository.findById(userId);
    }

    public Teller createTeller(CreateTellerDto tellerDto) {
        if (tellerRepository.existsByEmail(tellerDto.getEmail())) {
            throw new IllegalArgumentException("Email already in use");
        }

        Teller teller = Teller.builder()
            .tellerId(UUID.randomUUID().toString())
            .email(tellerDto.getEmail())
            .passwordHash(crypto.hash(tellerDto.getPassword()))
            .thaiName(tellerDto.getThaiName())
            .englishName(tellerDto.getEnglishName())
            .createdAt(LocalDateTime.now())
            .build();

        return tellerRepository.save(teller);
    }
    
    public Teller updateTeller(String userId, Teller updatedTeller) {
        Teller existing = tellerRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Teller not found"));
        existing.setEmail(updatedTeller.getEmail());
        existing.setPasswordHash(updatedTeller.getPasswordHash());
        existing.setThaiName(updatedTeller.getThaiName());
        existing.setEnglishName(updatedTeller.getEnglishName());
        return tellerRepository.save(existing);
    }

    public void deleteTeller(String userId) {
        tellerRepository.deleteById(userId);
    }
}
