package com.example.bank.mapper;

import com.example.bank.dto.CurrencyDto;
import com.example.bank.entity.Currency;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CurrencyMapper {
    CurrencyDto toDto(Currency currency);

    Currency toEntity(CurrencyDto currencyDTO);


}
