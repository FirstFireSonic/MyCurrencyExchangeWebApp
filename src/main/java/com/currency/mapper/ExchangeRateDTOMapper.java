package com.currency.mapper;

import com.currency.dto.ExchangeRateDTO;
import com.currency.models.ExchangeRate;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ExchangeRateDTOMapper implements Function<ExchangeRate, ExchangeRateDTO> {
    @Override
    public ExchangeRateDTO apply(ExchangeRate exchangeRate) {
        return new ExchangeRateDTO(
                exchangeRate.getBaseCurrency(),
                exchangeRate.getTargetCurrencyId(),
                exchangeRate.getRate()
        );
    }
}
