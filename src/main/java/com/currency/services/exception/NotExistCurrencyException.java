package com.currency.services.exception;

public class NotExistCurrencyException extends RuntimeException {
    public NotExistCurrencyException(String massage) {
        super(massage);
    }
}
