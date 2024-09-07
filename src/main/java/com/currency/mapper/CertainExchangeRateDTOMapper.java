package com.currency.mapper;

import com.currency.dto.CertainExchangeRateDTO;
import com.currency.dto.CurrencyDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CertainExchangeRateDTOMapper {
    public CertainExchangeRateDTO mapToDTO(Optional<CurrencyDTO> baseCurrency, Optional<CurrencyDTO> targetCurrency, BigDecimal rate) {
        return new CertainExchangeRateDTO(
                baseCurrency.orElse(null),
                targetCurrency.orElse(null),
                rate
        );
    }
}
