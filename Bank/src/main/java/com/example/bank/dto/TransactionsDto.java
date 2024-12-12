
package com.example.bank.dto;

import com.example.bank.entity.EnumCurrency;
import com.example.bank.entity.StatusTransactions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionsDto {

        private String receiver;

        private String sender;

        private BigDecimal amount;

        private String description;

        private StatusTransactions status;

        private BigDecimal balance;

        private CurrencyDto currency;
    }
