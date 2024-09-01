package com.currency.exception;

public class NoExchangeRateExistException extends RuntimeException {
    public NoExchangeRateExistException(String massage) {
        super(massage);
    }
}
