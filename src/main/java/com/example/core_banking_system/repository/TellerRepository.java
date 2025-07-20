package com.example.core_banking_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.core_banking_system.entity.Teller;

public interface TellerRepository extends JpaRepository<Teller, String> {
    boolean existsByEmail(String email);
}
