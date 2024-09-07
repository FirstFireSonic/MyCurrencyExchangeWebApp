package com.currency.controllers;

import com.currency.dto.CurrencyDTO;
import com.currency.models.Currency;
import com.currency.services.CurrencyService;
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
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

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

    @PostMapping("/add")
    public ResponseEntity<Currency> addNewCurrency(
            @RequestParam("name") String name,
            @RequestParam("code") String code,
            @RequestParam("sign") String sign) {

        if (name == null || name.isEmpty() || code == null || code.isEmpty() || sign == null || sign.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

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
    public ResponseEntity<Void> deleteCurrency(@RequestParam(value = "code", required = false) String code) {
        if (code == null || code.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        currencyService.deleteCurrencyByCode(code);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
