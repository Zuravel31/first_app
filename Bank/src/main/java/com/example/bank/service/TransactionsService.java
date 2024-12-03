package com.example.bank.service;

import com.example.bank.dto.TransactionsDto;
import com.example.bank.entity.Transactions;

import java.util.List;
import java.util.Optional;

public interface TransactionsService {

    TransactionsDto craeteTransactions(TransactionsDto transactionsDto);

    void deleteTransactions(Integer id);

    List<Transactions> getTransactionBy();

    Optional<TransactionsDto> updateTransactions(Integer id, TransactionsDto dto);
}
