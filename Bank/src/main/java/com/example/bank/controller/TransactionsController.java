package com.example.bank.controller;

import com.example.bank.dto.CurrencyDto;
import com.example.bank.dto.TransactionsDto;
import com.example.bank.entity.StatusTransactions;
import com.example.bank.service.CurrencyService;
import com.example.bank.service.TransactionsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api/bank")
@RequiredArgsConstructor
@Slf4j
public class TransactionsController {
    private final CurrencyService currencyService;
    private final TransactionsService service;

    @PostMapping
    public TransactionsDto createTransactions(@RequestBody @Validated TransactionsDto transactionsDto) {
        return service.craeteTransactions(transactionsDto);
    }

    @DeleteMapping("/{id}")// нужно вводить необходимое id в ручную
    public ResponseEntity<String> deleteTransactionsId(@PathVariable Integer id) { // @PathVariable всегда используется когда есть "/{}"
        boolean isDelete = service.deleteTransactions(id);
        if (isDelete) {
            return ResponseEntity.ok("Transactions delete secssesfule");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
    }

    @DeleteMapping("/balance")
    public ResponseEntity<String> deleteTransactionsBalance(@RequestBody BigDecimal balance) { // @PathVariable всегда используется когда есть "/{}"
        boolean isDelete = service.deleteTransactionsBalance(balance);
        if (isDelete) {
            return ResponseEntity.ok("Transactions delete secssesfule");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
    }

    @GetMapping
    public ResponseEntity<List<TransactionsDto>> getAllTransactions() {
        List<TransactionsDto> transactions = service.getAll();
        return ResponseEntity.ok(transactions);

    }

    @GetMapping("/balance")
    public List<TransactionsDto> getBalance(@RequestParam BigDecimal balance, @RequestParam StatusTransactions status) {
        return service.getSender(balance, status);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionsDto> updateTransactions(@PathVariable Integer id, @Validated @RequestBody TransactionsDto dto) {
        return service.updateTransactions(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/currency")
    public CurrencyDto createCurrency(@RequestBody CurrencyDto currencyDto) {
        return currencyService.createCurrency(currencyDto);
    }

    @DeleteMapping("/currency/{id}")
    public void deleteCurrency(@PathVariable Integer id) {
        boolean isDeleted = currencyService.deleteCurrency(id);
        if (!isDeleted) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Currency not found");
        }
    }

    @GetMapping("/currency")
    public ResponseEntity<List<CurrencyDto>> getAllCurrencies() {
        List<CurrencyDto> currency = currencyService.getAllCurrencies();
        return   ResponseEntity.ok(currency);
    }

    @GetMapping("/currency/balabce")
    public ResponseEntity<List<CurrencyDto>> getCurrenciesByCurrency(@RequestParam String currency) {
        List<CurrencyDto> currencies = currencyService.getCurrenciesByCurrency(currency);
        return ResponseEntity.ok(currencies);
    }

    @PutMapping("/currency/{id}")
    public CurrencyDto updateCurrency(@PathVariable Integer id, @RequestBody CurrencyDto currencyDto) {
        return currencyService.updateCurrency(id, currencyDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Currency not found"));
    }
}