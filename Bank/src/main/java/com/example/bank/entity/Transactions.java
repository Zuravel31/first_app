package com.example.bank.entity;

import io.swagger.models.auth.In;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@Data
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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "currency", nullable = false, referencedColumnName = "currency")
    private Currency currency;
}
