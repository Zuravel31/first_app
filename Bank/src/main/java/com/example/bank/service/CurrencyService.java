package com.example.bank.service;

import com.example.bank.dto.CurrencyDto;

import java.util.List;

public interface CurrencyService {
    CurrencyDto createCurrency(CurrencyDto currencyDto);

    List<CurrencyDto> getAllCurrencies();

    List<CurrencyDto> getCurrenciesByCurrency(String currency);

}