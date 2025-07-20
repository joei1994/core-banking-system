package com.example.core_banking_system.repository;

import com.example.core_banking_system.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
