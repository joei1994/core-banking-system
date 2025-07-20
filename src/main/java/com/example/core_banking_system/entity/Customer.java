package com.example.core_banking_system.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @Column(name = "customer_id", nullable = false, length = 36)
    private String customerId;

    private String email;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "citizen_id")
    private String citizenId;

    @Column(name = "thai_name")
    private String thaiName;

    @Column(name = "english_name")
    private String englishName;

    @Column(name = "pin_hash")
    private Integer pinHash;

    @Column(name = "created_by", length = 36)
    private String createdBy;

    @Column(name = "registered_at")
    private LocalDateTime registeredAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}

