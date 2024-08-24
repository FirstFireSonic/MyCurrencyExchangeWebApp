package com.currency.controllers;

import com.currency.models.Currency;
import com.currency.services.CurrencyService;
import com.currency.services.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    private CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService, ExchangeRateService exchangeRateService) {
        this.currencyService = currencyService;
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping("/all")
    public List<Currency> getAllAvailableCurrencies() {
        return currencyService.getCurrencies();
    }

    @GetMapping("/{sign}")
    public Optional<Currency> getCurrency(@PathVariable String sign) {
        return currencyService.getCurrency(sign);
    }

    @PostMapping("/add")
    public ResponseEntity<Currency> addNewCurrency(
            @RequestParam("name") String name,
            @RequestParam("code") String code,
            @RequestParam("sign") String sign) {
        Currency savedCurrency = currencyService.addCurrency(
                Currency.builder()
                        .code(code)
                        .fullName(name)
                        .sign(sign)
                        .build()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCurrency);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCurrency(@RequestParam(value = "code", required = false) String code) {
        if (code == null || code.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Parameter 'code' is missing");
        }
        currencyService.deleteCurrencyByCode(code);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
