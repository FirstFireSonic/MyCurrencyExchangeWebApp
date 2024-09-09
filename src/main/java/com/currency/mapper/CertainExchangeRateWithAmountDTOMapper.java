package com.currency.mapper;

import com.currency.dto.CertainExchangeRateWithAmountDTO;
import com.currency.dto.CurrencyDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CertainExchangeRateWithAmountDTOMapper {
    public CertainExchangeRateWithAmountDTO apply(CurrencyDTO baseCurrency, CurrencyDTO targetCurrency, BigDecimal rate, BigDecimal amount, BigDecimal convertedAmount) {
        return new CertainExchangeRateWithAmountDTO(
                baseCurrency,
                targetCurrency,
                rate,
                amount,
                convertedAmount
        );
    }
}
