
package com.example.bank.dto;


import com.example.bank.entity.StatusTransactions;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionsDto {
        @NotNull
        private String receiver;
        @NotNull
        private String sender;
        @NotNull
        @DecimalMin("0.01")
        private BigDecimal amount;
        @NotNull
        private String description;
        @NotNull
        private StatusTransactions status;
        @NotNull
        @DecimalMin("0.01")
        private BigDecimal balance;
        @NotNull
        private CurrencyDto currency;
    }
