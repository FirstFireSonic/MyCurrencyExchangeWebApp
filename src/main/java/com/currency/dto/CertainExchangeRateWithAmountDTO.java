package com.currency.dto;

import java.math.BigDecimal;

public record CertainExchangeRateWithAmountDTO(
        CurrencyDTO baseCurrency,
        CurrencyDTO targetCurrency,
        BigDecimal rate,
        BigDecimal amount,
        BigDecimal convertedAmount
) {
}
