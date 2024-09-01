package com.currency.services.exception;


public class NoCurrenciesFoundException extends RuntimeException {
    public NoCurrenciesFoundException(String message) {
        super(message);
    }
}
