package com.currency.services.exception;

public class TheSameCurrencyToExchangeException extends RuntimeException {
    public TheSameCurrencyToExchangeException(String massage) {
        super(massage);
    }
}
