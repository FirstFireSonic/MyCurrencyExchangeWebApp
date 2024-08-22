package com.currency.controllers;

import com.currency.models.Currency;
import com.currency.models.ExchangeRate;
import com.currency.services.CurrencyService;
import com.currency.services.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CurrencyController {

    private CurrencyService currencyService;
    private ExchangeRateService exchangeRateService;

    @Autowired
    public CurrencyController(CurrencyService currencyService, ExchangeRateService exchangeRateService) {
        this.currencyService = currencyService;
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping("/currencies")
    public List<Currency> getAllAvailableCurrencies() {
        return currencyService.getCurrencies();
    }

    @GetMapping("/exchange-rate")
    public List<ExchangeRate> getAllAvailableExchangeRate() {
        return exchangeRateService.getAllExchangeRates();
    }

}
