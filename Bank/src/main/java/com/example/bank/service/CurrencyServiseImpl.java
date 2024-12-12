package com.example.bank.service;

import com.example.bank.dto.CurrencyDto;
import com.example.bank.entity.Currency;


import com.example.bank.mapper.CurrencyMapper;
import com.example.bank.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class CurrencyServiseImpl implements CurrencyService {

    @Qualifier("currencyMapper")
    private final CurrencyMapper mapper;

    private final CurrencyRepository repository;

    @Override
    @Transactional
    public CurrencyDto createCurrency(CurrencyDto currencyDto) {
        Currency currencies = mapper.toEntity(currencyDto);
        Currency currencieSave = repository.save(currencies);
        return mapper.toDto(currencieSave);
    }

    @Override
    @Transactional
    public boolean deleteCurrency(Integer id) {
        return repository.findById(id)
                .map(entity -> {
                    repository.delete(entity);
                    repository.flush();
                    return true;
                })
                .orElse(false);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CurrencyDto> getAllCurrencies() {
        List<Currency> entities = repository.findAll();
        return entities.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Optional<CurrencyDto> updateCurrency(Integer id, CurrencyDto currencyDto) {
        return repository.findById(id)
                .map(entity -> {
                    mapper.toEntityUpdate(currencyDto, entity);
                    Currency currencySave = repository.save(entity);
                    return mapper.toDto(currencySave);
                });
    }

    @Override
    @Transactional(readOnly = true)
    public List<CurrencyDto> getCurrenciesByCurrency(String currency) {
        List<Currency> currencies = repository.findByCurrency(currency);
        return currencies.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

}
