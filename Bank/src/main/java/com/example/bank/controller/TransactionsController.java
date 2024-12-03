package com.example.bank.controller;

import com.example.bank.dto.TransactionsDto;
import com.example.bank.entity.Transactions;
import com.example.bank.service.TransactionsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/bank")
@RequiredArgsConstructor
@Slf4j
public class TransactionsController {

    private final TransactionsService service;

    @PostMapping
    public TransactionsDto createTransactions(@RequestBody @Validated TransactionsDto transactionsDto) {
        return service.craeteTransactions(transactionsDto);
    }

    @DeleteMapping("/{id}")// нужно вводить необходимое id в ручную
    public void deleteTransactions(@PathVariable Integer id) {
        service.deleteTransactions(id);
    }

    @GetMapping
    public List<Transactions> getTransactionBy() {
        return service.getTransactionBy();
    }

    @PutMapping("/{id}")
    public TransactionsDto updateTransactions(@PathVariable Integer id, @RequestBody @Validated TransactionsDto dto){
        return service.updateTransactions(id, dto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
