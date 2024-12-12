package com.example.bank.service;

import com.example.bank.dto.CurrencyDto;
import com.example.bank.dto.TransactionsDto;
import com.example.bank.entity.StatusTransactions;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface TransactionsService {

    TransactionsDto craeteTransactions(TransactionsDto transactionsDto);

    boolean deleteTransactions(Integer id);

    boolean deleteTransactionsBalance(BigDecimal balance);

    List<TransactionsDto> getAll();

    List<TransactionsDto> getSender(BigDecimal balance, StatusTransactions status);

    Optional<TransactionsDto> updateTransactions(Integer id, TransactionsDto dto);

}
