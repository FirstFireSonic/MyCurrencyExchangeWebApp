package com.currency.dto;

import com.currency.models.Currency;

import java.math.BigDecimal;

public record ExchangeRateDTO(
        Currency baseCurrency,
        Currency targetCurrencyId,
        BigDecimal rate
) {
}
