package com.example.bank.mapper;

import com.example.bank.dto.TransactionsDto;
import com.example.bank.entity.Transactions;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper(componentModel = "spring", uses = CurrencyMapper.class)
public interface TransactionsMapper {
    TransactionsDto toDto(Transactions transaction);

    void toEntityUpdate(TransactionsDto dto, @MappingTarget Transactions entity);

    Transactions toEntity(TransactionsDto dto);

    List<TransactionsDto> toDtoList(List<Transactions> transaction);


}