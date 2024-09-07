package com.currency.controllers;

import com.currency.dto.CertainExchangeRateDTO;
import com.currency.dto.ExchangeRateDTO;
import com.currency.services.CurrencyService;
import com.currency.services.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/all")
    public ResponseEntity<List<ExchangeRateDTO>> getAllAvailableExchangeRates() {
        List<ExchangeRateDTO> exchangeRates = exchangeRateService.getAllExchangeRates();
        if (exchangeRates.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return new ResponseEntity<>(exchangeRates, HttpStatus.OK);
        }
    }

    @GetMapping("/{codes}")
    public ResponseEntity<CertainExchangeRateDTO> getCertainExchangeRate(@PathVariable("codes") String codes) {

        String code1 = codes.substring(0, 3);
        String code2 = codes.substring(3, 6);

        if (code1 == null || code2 == null ||
                code1.isEmpty() || code2.isEmpty() ||
                !currencyService.existsCurrencyByCode(code1) ||
                !currencyService.existsCurrencyByCode(code2)) {
            return ResponseEntity.badRequest().build();
        } else {
            CertainExchangeRateDTO certainExchangeRateDTO = exchangeRateService.getCertainExchangeRate(code1, code2);
            return new ResponseEntity<>(certainExchangeRateDTO, HttpStatus.OK);
        }

    }

//    @GetMapping("/certain")
//    public ResponseEntity<String> getCertainExchangeRateWithAmount(
//            @RequestParam("from") String from,
//            @RequestParam("to") String to,
//            @RequestParam("amount") int amount) {
//
//    }
}
