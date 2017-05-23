package com.uniara.rest.service;

import com.uniara.rest.domain.ExchangeRate;
import com.uniara.rest.exceptions.AlreadyExistsException;
import com.uniara.rest.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by carlos.ribeiro on 5/22/17.
 */

@Service
public class ExchangeRateService {
    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    public void create(final ExchangeRate exchangeRate) throws AlreadyExistsException {
        if(findBySymbol(exchangeRate.getSymbol()) != null) {
            throw new AlreadyExistsException();
        }
        exchangeRateRepository.save(exchangeRate);
    }

    public List<ExchangeRate> findAll() {
        return exchangeRateRepository.findAll();
    }

    public ExchangeRate findBySymbol(final String symbol) {
        return this.exchangeRateRepository.findBySymbol(symbol);
    }

    public boolean deleteBySymbol(final String symbol) {
        return this.exchangeRateRepository.deleteBySymbol(symbol);
    }
}
