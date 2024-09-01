package com.currency.services;

import com.currency.dto.ExchangeRateDTO;
import com.currency.mapper.ExchangeRateDTOMapper;
import com.currency.models.ExchangeRate;
import com.currency.repositories.ExchangeRateRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ExchangeRateService {

    private ExchangeRateRepository exchangeRateRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private ExchangeRateDTOMapper exchangeRateDTOMapper;

    @Autowired
    public ExchangeRateService(ExchangeRateRepository exchangeRateRepository, EntityManager entityManager, ExchangeRateDTOMapper exchangeRateDTOMapper) {
        this.exchangeRateRepository = exchangeRateRepository;
        this.entityManager = entityManager;
        this.exchangeRateDTOMapper = exchangeRateDTOMapper;
    }

    public List<ExchangeRateDTO> getAllExchangeRates() {
        return exchangeRateRepository.findAll()
                .stream()
                .map(exchangeRateDTOMapper)
                .collect(Collectors.toList());
    }

    public double getExchangeRateByTargetCurrencyCode(String targetCurrencyCode) {
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

}
