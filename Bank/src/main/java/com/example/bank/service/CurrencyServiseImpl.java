package com.example.bank.service;

import com.example.bank.dto.CurrencyDto;
import com.example.bank.entity.Currency;
import com.example.bank.entity.EnumCurrency;
import com.example.bank.mapper.CurrencyMapper;
import com.example.bank.repository.CurrencyRepository;
import com.example.bank.repository.TransactionsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class CurrencyServiseImpl implements CurrencyService {

    @Autowired
    private TransactionsRepository transactionsRepository;

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
    @Transactional(readOnly = true)
    public List<CurrencyDto> getAllCurrencies() {
        List<Currency> entities = repository.findAll();
        return entities.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CurrencyDto> getCurrenciesByCurrency(String currency) {
        EnumCurrency enumCurrency = fromString(currency);
        List<Currency> currencies = repository.findByCurrency(enumCurrency);
        return currencies.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public EnumCurrency fromString(String currency) {
        try {
            return EnumCurrency.valueOf(currency.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid currency: " + currency);
        }
    }

}

