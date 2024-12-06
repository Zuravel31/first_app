package com.example.bank.controller;

import com.example.bank.dto.TransactionsDto;
import com.example.bank.entity.StatusTransactions;
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
    @GetMapping
    public List<TransactionsDto> getAll() {
        return service.getAll();

    }

    @GetMapping("/balance")
    public List<TransactionsDto> getBalance(@RequestParam BigDecimal balance, @RequestParam StatusTransactions status) {
        return service.getBalance(balance, status);
    }

    @PutMapping("/{id}")
    public TransactionsDto updateTransactions(@PathVariable Integer id, @Validated TransactionsDto dto) {
        return service.updateTransactions(id, dto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}