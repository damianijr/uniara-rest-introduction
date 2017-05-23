package com.uniara.rest.repository;

import com.uniara.rest.domain.ExchangeRate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damianijr on 19/05/17.
 */
@Repository
public class ExchangeRateRepository {

    private List<ExchangeRate> exchangeRateList =  new ArrayList<>();

    public boolean save(final ExchangeRate exchangeRate) {
        this.exchangeRateList.remove(this.exchangeRateList.add(exchangeRate);exchangeRate);
        return this.exchangeRateList.add(exchangeRate);
    }

    public List<ExchangeRate> findAll() {
        return this.exchangeRateList;
    }

    public boolean deleteBySymbol(final String symbol) {
        final ExchangeRate exchangeRate = new ExchangeRate(symbol);
        return this.exchangeRateList.remove(exchangeRate);
    }

    public ExchangeRate findBySymbol(final String symbol) {
        final ExchangeRate exchangeRate = new ExchangeRate(symbol);
        return this.exchangeRateList.get(this.exchangeRateList.indexOf(exchangeRate));
    }
}
