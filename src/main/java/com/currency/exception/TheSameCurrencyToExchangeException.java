package com.currency.exception;

public class TheSameCurrencyToExchangeException extends RuntimeException {
    public TheSameCurrencyToExchangeException(String massage) {
        super(massage);
    }
}
