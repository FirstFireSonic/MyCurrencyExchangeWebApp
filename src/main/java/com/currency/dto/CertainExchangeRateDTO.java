package com.currency.dto;

import java.math.BigDecimal;

public record CertainExchangeRateDTO(
        CurrencyDTO baseCurrency,
        CurrencyDTO targetCurrency,
        BigDecimal rate
) {
}
