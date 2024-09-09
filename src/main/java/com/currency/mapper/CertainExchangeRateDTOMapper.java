package com.currency.mapper;

import com.currency.dto.CertainExchangeRateDTO;
import com.currency.dto.CurrencyDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CertainExchangeRateDTOMapper {
    public CertainExchangeRateDTO apply(CurrencyDTO baseCurrency, CurrencyDTO targetCurrency, BigDecimal rate) {
        return new CertainExchangeRateDTO(
                baseCurrency,
                targetCurrency,
                rate
        );
    }
}
