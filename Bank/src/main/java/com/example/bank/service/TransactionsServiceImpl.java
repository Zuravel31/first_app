package com.example.bank.service;

import com.example.bank.dto.TransactionsDto;
import com.example.bank.entity.StatusTransactions;
import com.example.bank.entity.Transactions;
import com.example.bank.mapper.TransactionsMapper;
import com.example.bank.repository.TransactionsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Slf4j
@Service
public class TransactionsServiceImpl implements TransactionsService {
    private final TransactionsMapper mapper;
    private final TransactionsRepository repository;

    @Override
    public TransactionsDto craeteTransactions(TransactionsDto transactionDTORequest) {
        Transactions entity = mapper.toEntity(transactionDTORequest);
        Transactions entitySaved = repository.save(entity);
        TransactionsDto transactionDTOResponse = mapper.toDto(entitySaved);
        return transactionDTOResponse;
    }

    @Override
    public boolean deleteTransactions(Integer id) {
        return repository.findById(id)
                .map(entity -> {
                    repository.delete(entity);
                    repository.flush();
                    return true;
                })
                .orElse(false);

    }

    public List<TransactionsDto> getAll() {
        List<Transactions> entities = repository.findAll();
        return entities.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TransactionsDto> getBalance(BigDecimal balance, StatusTransactions status) {
        List<Transactions> entities = repository.findAll();
        log.info("Entities retrieved from database: {}", entities);

        List<TransactionsDto> dtos = entities.stream()
                .filter(entity -> entity.getBalance().compareTo(balance) > 0
                        && entity.getStatus() == status)
                .map(mapper::toDto)
                .collect(Collectors.toList());

        log.info("DTOs after mapping: {}", dtos);
        return dtos;
    }

    @Override
    public Optional<TransactionsDto> updateTransactions(Integer id, TransactionsDto dto) {
        return repository.findById(id)
                .map(entity -> {
                    mapper.toEntityUpdate(dto, entity);
                    Transactions entitySaved = repository.save(entity);
                    return mapper.toDto(entitySaved);
                });
    }
}