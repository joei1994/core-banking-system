package com.example.core_banking_system.repository;

import com.example.core_banking_system.entity.Customer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, String> {
    boolean existsByEmail(String email);
    Optional<Customer> findByEmail(String email);
}
