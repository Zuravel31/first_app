package com.example.bank.mapper;

import com.example.bank.dto.CurrencyDto;
import com.example.bank.entity.Currency;
import com.example.bank.entity.EnumCurrency;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CurrencyMapper {
    CurrencyDto toDto(Currency currency);

    Currency toEntity(CurrencyDto currencyDTO);


    default EnumCurrency map(Currency currency) {
        if (currency != null && currency.getCurrency() != null) {
            return currency.getCurrency();
        }
        return null; // или бросьте исключение, если это недопустимо
    }
}
//EnumCurrency map(Currency currency);