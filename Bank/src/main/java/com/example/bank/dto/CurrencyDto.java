package com.example.bank.dto;

import com.example.bank.entity.EnumCurrency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyDto {
    private EnumCurrency currency;
}
