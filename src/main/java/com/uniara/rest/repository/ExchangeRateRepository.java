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
        return this.exchangeRateList.add(exchangeRate);
    }

    public List<ExchangeRate> findAll() {
        return this.exchangeRateList;
    }

    public boolean deleteBySymbol(final String symbol) {
        final ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.setSymbol(symbol);
        return this.exchangeRateList.remove(exchangeRate);
    }
}
