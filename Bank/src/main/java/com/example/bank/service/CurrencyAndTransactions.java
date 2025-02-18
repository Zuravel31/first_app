package com.example.bank.service;

import com.example.bank.entity.Currency;
import com.example.bank.entity.Transactions;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;


public class CurrencyAndTransactions {
    @JsonManagedReference//от рекурсии
    private List<Transactions> transactions;
    @JsonManagedReference//от рекурсии
    private Currency currency;

    public CurrencyAndTransactions(Currency currency, List<Transactions> transactions) {
        this.currency = currency;
        this.transactions = transactions != null ? transactions : new ArrayList<>();
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions != null ? transactions : new ArrayList<>();
    }
}

