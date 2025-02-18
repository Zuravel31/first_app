package com.example.bank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String receiver;

    private String sender;

    private BigDecimal amount;

    private String description;

    @Enumerated(EnumType.STRING)
    private StatusTransactions status;

    private BigDecimal balance;
}