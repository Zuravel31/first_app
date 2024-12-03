package com.example.bank.mapper;

import com.example.bank.dto.TransactionsDto;
import com.example.bank.entity.Transactions;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TransactionsMapper {

    TransactionsDto toDto(Transactions entity);
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Transactions toEntity(TransactionsDto dto);

    void toEntityUpdate(TransactionsDto dto, @MappingTarget Transactions entity);
}
