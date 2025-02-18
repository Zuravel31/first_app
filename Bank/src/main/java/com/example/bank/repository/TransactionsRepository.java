package com.example.bank.repository;

import com.example.bank.entity.Currency;
import com.example.bank.entity.StatusTransactions;
import com.example.bank.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {
    List<Transactions> findByBalance(BigDecimal balance);

    List<Transactions> findByBalanceAndStatus(BigDecimal amount, StatusTransactions status);

    List<Transactions> findByCurrency(Currency currency);
}