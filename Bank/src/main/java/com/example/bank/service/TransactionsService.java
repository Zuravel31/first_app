package com.example.bank.service;

import com.example.bank.dto.TransactionsDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface TransactionsService {

    TransactionsDto craeteTransactions(TransactionsDto transactionsDto);

    boolean deleteTransactions(Integer id);

    List<TransactionsDto> getAll();

    List<TransactionsDto> getBalance(BigDecimal balance);

    Optional<TransactionsDto> updateTransactions(Integer id, TransactionsDto dto);


}
