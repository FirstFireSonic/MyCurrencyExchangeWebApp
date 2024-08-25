package com.currency.services;

import com.currency.models.Currency;
import com.currency.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CurrencyService {

    private CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public List<Currency> getCurrencies() {
        return currencyRepository.findAll();
    }

    public Optional<Currency> getCurrency(String sign) {
        return currencyRepository.findCurrenciesByCode(sign);
    }

    @Transactional(readOnly = false)
    public Currency addCurrency(Currency currency) {
        return currencyRepository.save(currency);
    }

    @Transactional(readOnly = false)
    public void deleteCurrencyByCode(String code) {
        currencyRepository.deleteByCode(code);
    }

    public boolean existsCurrencyByCode(String code) {
        return currencyRepository.existsByCode(code);
    }

}
