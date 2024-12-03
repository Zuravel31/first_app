package com.example.bank.repository;

import com.example.bank.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {
    List<Transactions> findAllById( Integer id);
}
