package com.example.bank.service;

import com.example.bank.dto.TransactionsDto;
import com.example.bank.entity.Transactions;
import com.example.bank.mapper.TransactionsMapper;
import com.example.bank.repository.TransactionsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        entity.setUpdatedAt(LocalDateTime.now()); // Устанавливаем текущее время
        entity.setCreatedAt(LocalDateTime.now());// Устанавливаем текущее время
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
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TransactionsDto> updateTransactions(Integer id, TransactionsDto dto){
        return repository.findById(id)
                .map(entity -> {
                    entity.setUpdatedAt(LocalDateTime.now()); // Устанавливаем текущее время
                    entity.setCreatedAt(LocalDateTime.now()); // Устанавливаем текущее время
                    mapper.toEntityUpdate(dto, entity);
                    Transactions entitySaved = repository.save(entity);
                    return mapper.toDto(entitySaved);
                });
    }


}


