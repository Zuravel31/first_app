package com.example.bank.service;

import com.example.bank.dto.CurrencyDto;

import java.util.List;
import java.util.Optional;

public interface CurrencyService {
    CurrencyDto createCurrency(CurrencyDto currencyDto);

    boolean deleteCurrency(Integer id);

    List<CurrencyDto> getAllCurrencies();

    Optional<CurrencyDto> updateCurrency(Integer id, CurrencyDto currencyDto);

    List<CurrencyDto> getCurrenciesByCurrency(String currency);

}