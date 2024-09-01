package com.currency.services.controllersServices;

import com.currency.dto.CurrencyDTO;
import com.currency.services.mapper.CurrencyDTOMapper;
import com.currency.models.Currency;
import com.currency.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class CurrencyService {

    private final CurrencyRepository currencyRepository;
    private final CurrencyDTOMapper currencyDTOMapper;

    @Autowired
    public CurrencyService(CurrencyRepository currencyRepository, CurrencyDTOMapper currencyDTOMapper) {
        this.currencyRepository = currencyRepository;
        this.currencyDTOMapper = currencyDTOMapper;
    }

    public List<CurrencyDTO> getCurrencies() {
        return currencyRepository.findAll()
                .stream()
                .map(currencyDTOMapper)
                .collect(Collectors.toList());
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
