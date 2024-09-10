package com.currency.services;

import com.currency.dto.CertainExchangeRateDTO;
import com.currency.dto.CertainExchangeRateWithAmountDTO;
import com.currency.dto.CurrencyDTO;
import com.currency.dto.ExchangeRateDTO;
import com.currency.mapper.CertainExchangeRateDTOMapper;
import com.currency.mapper.CertainExchangeRateWithAmountDTOMapper;
import com.currency.mapper.CurrencyDTOMapper;
import com.currency.mapper.ExchangeRateDTOMapper;
import com.currency.models.Currency;
import com.currency.repositories.ExchangeRateRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ExchangeRateService {

    @PersistenceContext
    private final EntityManager entityManager;

    private final ExchangeRateRepository exchangeRateRepository;

    private final ExchangeRateDTOMapper exchangeRateDTOMapper;

    private final CertainExchangeRateDTOMapper certainExchangeRateDTOMapper;

    private final CurrencyService currencyService;

    private final CurrencyDTOMapper currencyDTOMapper;

    private final CertainExchangeRateWithAmountDTOMapper certainExchangeRateWithAmountDTOMapper;

    public List<ExchangeRateDTO> getAllExchangeRates() {
        return exchangeRateRepository.findAll()
                .stream()
                .map(exchangeRateDTOMapper)
                .collect(Collectors.toList());
    }

    private double getExchangeRateByTargetCurrencyCode(String targetCurrencyCode) {
        if ("USD".equals(targetCurrencyCode)) {
            return 1.0;
        }

        String sql = "SELECT er.rate " +
                "FROM currency_exchange.exchange_rate er " +
                "JOIN currency_exchange.currency c ON c.id = er.target_currency_id " +
                "WHERE c.code = :targetCurrencyCode";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("targetCurrencyCode", targetCurrencyCode);

        try {
            Object result = query.getSingleResult();
            if (result == null) {
                throw new IllegalArgumentException("No exchange rate found for the currency code: " + targetCurrencyCode);
            }
            return ((Number) result).doubleValue();
        } catch (NoResultException e) {
            throw new IllegalArgumentException("No exchange rate found for the currency code: " + targetCurrencyCode, e);
        }
    }

    private BigDecimal getExchangeRate(String code1, String code2) {
        BigDecimal code1Value = BigDecimal.valueOf(getExchangeRateByTargetCurrencyCode(code1));
        BigDecimal code2Value = BigDecimal.valueOf(getExchangeRateByTargetCurrencyCode(code2));

        BigDecimal result = code1Value.divide(code2Value, 6, BigDecimal.ROUND_DOWN);

        if (result.stripTrailingZeros().scale() <= 2) {
            return code1Value.divide(code2Value, 2, BigDecimal.ROUND_DOWN);
        } else {
            return result;
        }
    }

    public CertainExchangeRateDTO getCertainExchangeRate(String code1, String code2) {

        Currency baseCurrencyOptional = currencyService.getCurrency(code1)
                .orElseThrow(() -> new IllegalArgumentException("Invalid base currency code: " + code1));
        Currency targetCurrencyOptional = currencyService.getCurrency(code2)
                .orElseThrow(() -> new IllegalArgumentException("Invalid target currency code: " + code2));

        CurrencyDTO baseCurrency = currencyDTOMapper.apply(baseCurrencyOptional);
        CurrencyDTO targetCurrency = currencyDTOMapper.apply(targetCurrencyOptional);


        BigDecimal rate = getExchangeRate(code1, code2);

        return certainExchangeRateDTOMapper.apply(baseCurrency, targetCurrency, rate);
    }

    public CertainExchangeRateWithAmountDTO getCertainExchangeRateWithAmount (String code1, String code2, BigDecimal amount) {

        Currency baseCurrencyOptional = currencyService.getCurrency(code1)
                .orElseThrow(() -> new IllegalArgumentException("Invalid base currency code: " + code1));
        Currency targetCurrencyOptional = currencyService.getCurrency(code2)
                .orElseThrow(() -> new IllegalArgumentException("Invalid target currency code: " + code2));

        CurrencyDTO baseCurrency = currencyDTOMapper.apply(baseCurrencyOptional);
        CurrencyDTO targetCurrency = currencyDTOMapper.apply(targetCurrencyOptional);

        BigDecimal rate = getExchangeRate(code1, code2);

        BigDecimal convertedAmount = amount.multiply(rate);

        return certainExchangeRateWithAmountDTOMapper.apply(targetCurrency, baseCurrency, rate, amount, convertedAmount);
    }

}
