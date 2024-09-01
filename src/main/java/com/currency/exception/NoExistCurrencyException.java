package com.currency.exception;

public class NoExistCurrencyException extends RuntimeException {
    public NoExistCurrencyException(String massage) {
        super(massage);
    }
}
