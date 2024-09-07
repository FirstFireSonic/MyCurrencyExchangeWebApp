package com.currency.mapper;

import com.currency.dto.CertainExchangeRateWithAmountDTO;
import com.currency.dto.CurrencyDTO;
import com.currency.models.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CertainExchangeRateWithAmountDTOMapper {

    private CurrencyDTOMapper currencyDTOMapper;

    @Autowired
    public CertainExchangeRateWithAmountDTOMapper(CurrencyDTOMapper currencyDTOMapper) {
        this.currencyDTOMapper = currencyDTOMapper;
    }

    public CertainExchangeRateWithAmountDTO mapToDTO(Currency baseCurrency, Currency targetCurrency, BigDecimal rate, BigDecimal amount) {

        CurrencyDTO baseCurrencyDTO = currencyDTOMapper.apply(baseCurrency);
        CurrencyDTO targetCurrencyDTO = currencyDTOMapper.apply(targetCurrency);

        BigDecimal convertedAmount = amount.multiply(rate);

        return new CertainExchangeRateWithAmountDTO(
                baseCurrencyDTO,
                targetCurrencyDTO,
                rate,
                amount,
                convertedAmount
        );
    }
}
