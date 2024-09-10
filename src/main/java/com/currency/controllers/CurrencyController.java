package com.currency.controllers;

import com.currency.dto.CurrencyDTO;
import com.currency.models.Currency;
import com.currency.services.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/currency")
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping("/all")
    public ResponseEntity<List<CurrencyDTO>> getAllAvailableCurrencies() {

        List<CurrencyDTO> allCurrencies = currencyService.getCurrencies();

        if (allCurrencies.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(allCurrencies);
        }

    }

    @GetMapping("/{sign}")
    public ResponseEntity<Currency> getCurrency(@PathVariable("sign") String sign) {

        if (sign == null || sign.isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else {
            Optional<Currency> optionalCurrency = currencyService.getCurrency(sign);
            return optionalCurrency.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

    }

}
