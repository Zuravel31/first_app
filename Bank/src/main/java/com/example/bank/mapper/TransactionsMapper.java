package com.example.bank.mapper;

import com.example.bank.dto.TransactionsDto;
import com.example.bank.entity.Transactions;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface TransactionsMapper {

    Transactions toEntity(TransactionsDto dto);

    TransactionsDto toDto(Transactions entity);

    void toEntityUpdate(TransactionsDto dto, @MappingTarget Transactions entity);
}
