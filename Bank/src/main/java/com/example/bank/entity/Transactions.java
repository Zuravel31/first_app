package com.example.bank.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@Data
@ToString(exclude = "currency")
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

    @JsonBackReference//от рекурсии
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "currency_id", nullable = false)
    private Currency currency;
}
