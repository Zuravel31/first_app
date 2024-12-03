package com.example.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionsDto {

    private String receiver;

    private String sender;

    private BigDecimal amount;

    private String description;

    private String status;

    private BigDecimal  balance;
}
