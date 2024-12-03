package com.example.bank.service;

public class TransactionsServiceException extends Throwable {
    public TransactionsServiceException(String message) {
        super(message);
    }

    public TransactionsServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public TransactionsServiceException(Throwable cause) {
        super(cause);
    }
}
