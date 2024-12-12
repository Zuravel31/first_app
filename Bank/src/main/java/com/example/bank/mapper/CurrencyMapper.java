package com.example.bank.mapper;

import com.example.bank.dto.CurrencyDto;
import com.example.bank.entity.Currency;

import jakarta.activation.MimeType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CurrencyMapper {
    CurrencyDto toDto(Currency currency);

    void toEntityUpdate(CurrencyDto dto,@MappingTarget Currency entity);

    Currency toEntity(CurrencyDto currencyDTO);


}
