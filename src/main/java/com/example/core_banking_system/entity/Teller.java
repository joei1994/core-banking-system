package com.example.core_banking_system.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Entity
@Table(name = "teller")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teller {

    @Id
    @Column(name = "teller_id", nullable = false, length = 36)
    private String tellerId;

    private String email;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "thai_name")
    private String thaiName;

    @Column(name = "english_name")
    private String englishName;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}