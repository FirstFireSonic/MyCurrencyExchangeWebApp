package com.currency.controllers;

import com.currency.dto.ExchangeRateDTO;
import com.currency.exception.NoExchangeRateExistException;
import com.currency.services.CurrencyService;
import com.currency.services.ExchangeRateService;
import com.currency.exception.NoExistCurrencyException;
import com.currency.exception.TheSameCurrencyToExchangeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/exchange-rate")
public class ExchangeRateController {

    private ExchangeRateService exchangeRateService;
    private CurrencyService currencyService;

    @Autowired
    public ExchangeRateController(ExchangeRateService exchangeRateService, CurrencyService currencyService) {
        this.exchangeRateService = exchangeRateService;
        this.currencyService = currencyService;
    }

    @GetMapping("all")
    public ResponseEntity<List<ExchangeRateDTO>> getAllAvailableExchangeRates() {
        List<ExchangeRateDTO> exchangeRates = exchangeRateService.getAllExchangeRates();
        if (exchangeRates.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(exchangeRates);
        }
    }

    @GetMapping("{codes}")
    public ResponseEntity<String> getCertainExchangeRate(@PathVariable("codes") String codes) {
        String code1 = codes.substring(0, 3);
        String code2 = codes.substring(3, 6);

        if (!currencyService.existsCurrencyByCode(code1) ||
                !currencyService.existsCurrencyByCode(code2)) {
            throw new NoExistCurrencyException("This currency does not exist!");
        }

        if (code1.equals(code2)) {
            throw new TheSameCurrencyToExchangeException("Those currencies are the same!");
        }

        BigDecimal code1Value = BigDecimal.valueOf(exchangeRateService.getExchangeRateByTargetCurrencyCode(code1));
        BigDecimal code2Value = BigDecimal.valueOf(exchangeRateService.getExchangeRateByTargetCurrencyCode(code2));

        BigDecimal currency = code1Value.divide(code2Value, 6, BigDecimal.ROUND_DOWN);
        String result = currency.toString();
        if (result.endsWith(".000000")) {
            result = result.substring(0, result.indexOf('.'));
        }
        String formattedResponse = "";
        if (code1.equals("USD") || code2.equals("USD")) {
            formattedResponse = "1-" + code1 + "/" + code2 + "-" + result;
        } else {
            formattedResponse = "1-" + code2 + "/" + code1 + "-" + result;
        }
        return new ResponseEntity<>(formattedResponse, HttpStatus.OK);
    }

//    @GetMapping("/certain")
//    public ResponseEntity<String> getCertainExchangeRateWithAmount(
//            @RequestParam("from") String from,
//            @RequestParam("to") String to,
//            @RequestParam("amount") int amount) {
//
//    }
}
