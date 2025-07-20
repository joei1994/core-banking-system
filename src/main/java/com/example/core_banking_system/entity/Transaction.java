package com.example.core_banking_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @Column(name = "transaction_id", nullable = false, length = 36)
    private String transactionId;

    @Column(name = "account_id", nullable = false, length = 36)
    private String accountId;

    private BigDecimal amount;

    @Column(name = "transaction_type")
    private String transactionType; // DEPOSIT, WITHDRAW, TRANSFER

    @Column(name = "reference_account")
    private String referenceAccount; // UUID of target account for TRANSFER

    private LocalDateTime timestamp;

    @Column(name = "performed_by")
    private String performedBy; // Teller UUID

    private String status; // PENDING, COMPLETE, FAILED
}
