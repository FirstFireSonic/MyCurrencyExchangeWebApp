package com.currency.mapper;

import com.currency.dto.CertainExchangeRateWithAmountDTO;
import com.currency.dto.CurrencyDTO;
import com.currency.models.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CertainExchangeRateWithAmountDTOMapper {

    private CurrencyDTOMapper currencyDTOMapper;

    @Autowired
    public CertainExchangeRateWithAmountDTOMapper(CurrencyDTOMapper currencyDTOMapper) {
        this.currencyDTOMapper = currencyDTOMapper;
    }

    public CertainExchangeRateWithAmountDTO mapToDTO(CurrencyDTO baseCurrency, CurrencyDTO targetCurrency, BigDecimal rate, BigDecimal amount, BigDecimal convertedAmount) {

        return new CertainExchangeRateWithAmountDTO(
                baseCurrency,
                targetCurrency,
                rate,
                amount,
                convertedAmount
        );
    }
}
