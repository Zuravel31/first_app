package com.example.bank.service;

import com.example.bank.dto.TransactionsDto;
import com.example.bank.entity.Currency;
import com.example.bank.entity.StatusTransactions;
import com.example.bank.entity.Transactions;
import com.example.bank.mapper.TransactionsMapper;
import com.example.bank.repository.CurrencyRepository;
import com.example.bank.repository.TransactionsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class TransactionsServiceImpl implements TransactionsService {
    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private TransactionsRepository repository;

    @Autowired
    private TransactionsMapper mapper;

    @Override
    @Transactional
    public TransactionsDto craeteTransactions(TransactionsDto transactionDTORequest) {
        Transactions entity = mapper.toEntity(transactionDTORequest);
        Transactions entitySaved = repository.save(entity);
        return mapper.toDto(entitySaved);
    }

    @Override
    @Transactional
    public boolean deleteTransactions(Integer id) {
        return repository.findById(id)
                .map(entity -> {
                    repository.delete(entity);
                    repository.flush();
                    return true;
                })
                .orElse(false);

    }

    @Override
    @Transactional
    public boolean deleteTransactionsBalance(BigDecimal balance) {
        List<Transactions> transactions = repository.findByBalance(balance);
        if (transactions.isEmpty()) {
            return false;
        }
        repository.deleteAll(transactions);
        repository.flush();
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TransactionsDto> getAll() {
        List<Transactions> transactions = repository.findAll();
        return mapper.toDtoList(transactions);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TransactionsDto> getSender(BigDecimal balance, StatusTransactions status) {
        List<Transactions> entities = repository.findByBalanceAndStatus(balance, status);
        return mapper.toDtoList(entities); //.filter(entity -> entity.getBalance().compareTo(balance) == 0 // если нужно выводить больше или меньше баланса все транзакции, то нужно менять знаки < >// && entity.getStatus() == status) //что бы искать по sender(или по стрингу(если просто слово застолбить то добавить кавычки "слово")) sender.equals(entity.getSender())
    }

    @Override
    @Transactional
    public Optional<TransactionsDto> updateTransactions(Integer id, TransactionsDto dto) {
        return repository.findById(id)
                .map(entity -> {
                    log.info("Updating transaction with ID: {}", id);
                    mapper.toEntityUpdate(dto, entity);
                    Transactions entitySaved = repository.save(entity);
                    log.info("Transaction with ID {} updated successfully", id);
                    return mapper.toDto(entitySaved);
                });
    }

    @Override
    public CurrencyAndTransactions getTransactionsByCurrency(Integer currencyId) {
        Currency cur = currencyRepository.findById(currencyId)
                .orElseThrow(() -> new RuntimeException("Currency not found"));
        List<Transactions> transactions = repository.findByCurrency(cur);
        return new CurrencyAndTransactions(cur, transactions);
    }
}

