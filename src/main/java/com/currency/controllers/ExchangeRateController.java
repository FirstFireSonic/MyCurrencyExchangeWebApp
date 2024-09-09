package com.currency.controllers;

import com.currency.dto.CertainExchangeRateDTO;
import com.currency.dto.CertainExchangeRateWithAmountDTO;
import com.currency.dto.ExchangeRateDTO;
import com.currency.services.CurrencyService;
import com.currency.services.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/all")
    public ResponseEntity<List<ExchangeRateDTO>> getAllAvailableExchangeRates() {

        List<ExchangeRateDTO> exchangeRates = exchangeRateService.getAllExchangeRates();

        if (exchangeRates.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(exchangeRates);
        }

    }

    @GetMapping("/{codes}")
    public ResponseEntity<CertainExchangeRateDTO> getCertainExchangeRate(@PathVariable("codes") String codes) {

        if (codes.length() != 6) {
            return ResponseEntity.badRequest().build();
        }

        String code1 = codes.substring(0, 3);
        String code2 = codes.substring(3, 6);

        if (code1.isEmpty() || code2.isEmpty() ||
                !currencyService.existsCurrencyByCode(code1) ||
                !currencyService.existsCurrencyByCode(code2)) {
            return ResponseEntity.badRequest().build();
        } else {
            CertainExchangeRateDTO certainExchangeRateDTO = exchangeRateService.getCertainExchangeRate(code1, code2);
            return ResponseEntity.ok(certainExchangeRateDTO);
        }

    }

    @GetMapping("/certain")
    public ResponseEntity<CertainExchangeRateWithAmountDTO> getCertainExchangeRateWithAmount(
            @RequestParam("from") String from,
            @RequestParam("to") String to,
            @RequestParam("amount") BigDecimal amount) {

        if (from == null || to == null ||
                from.isEmpty() || to.isEmpty() ||
                !currencyService.existsCurrencyByCode(from) ||
                !currencyService.existsCurrencyByCode(to)) {
            return ResponseEntity.badRequest().build();
        } else {
            CertainExchangeRateWithAmountDTO certainExchangeRateDTO = exchangeRateService.getCertainExchangeRateWithAmount(to, from, amount);
            return ResponseEntity.ok(certainExchangeRateDTO);
        }

    }

}
