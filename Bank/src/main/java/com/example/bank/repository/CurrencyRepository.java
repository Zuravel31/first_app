package com.example.bank.repository;

import com.example.bank.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
    List<Currency> findByCurrency(String currency);
}
