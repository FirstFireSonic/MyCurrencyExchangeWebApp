package com.currency.controllers;

import com.currency.models.ExchangeRate;
import com.currency.services.CurrencyService;
import com.currency.services.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<ExchangeRate> getAllAvailableExchangeRate() {
        return exchangeRateService.getAllExchangeRates();
    }

    @GetMapping("{codes}")
    public ResponseEntity<String> getCertainExchangeRate(@PathVariable("codes") String codes) {
        String code1 = codes.substring(0, 3);
        String code2 = codes.substring(3, 6);

        if (!currencyService.existsCurrencyByCode(code1) ||
                !currencyService.existsCurrencyByCode(code2)) {
            /*
            * TODO
            *  -Redirect to page where new currency and exchange rate can be added.
            */
            return new  ResponseEntity<>("Nothing", HttpStatus.OK);
        }

        if (code1.equals(code2)) {
            return new ResponseEntity<>("You try to get exchange rate of two same currencies, the result will always be 1/1.", HttpStatus.OK);
        }

        BigDecimal code1Value = BigDecimal.valueOf(exchangeRateService.getExchangeRateByTargetCurrencyCode(code1));
        BigDecimal code2Value = BigDecimal.valueOf(exchangeRateService.getExchangeRateByTargetCurrencyCode(code2));

        /*
        *  TODO
        *   -Replace BigDecimal with something better, because it is deprecated.
        */

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
}
