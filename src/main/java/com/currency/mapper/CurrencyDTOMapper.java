package com.currency.mapper;

import com.currency.dto.CurrencyDTO;
import com.currency.models.Currency;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CurrencyDTOMapper implements Function<Currency, CurrencyDTO> {
    @Override
    public CurrencyDTO apply(Currency currency) {
        return new CurrencyDTO(
                currency.getCode(),
                currency.getFullName(),
                currency.getSign()
        );
    }
}
