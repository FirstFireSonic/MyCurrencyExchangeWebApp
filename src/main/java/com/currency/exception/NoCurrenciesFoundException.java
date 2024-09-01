package com.currency.exception;


public class NoCurrenciesFoundException extends RuntimeException {
    public NoCurrenciesFoundException(String message) {
        super(message);
    }
}
