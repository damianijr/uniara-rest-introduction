package com.uniara.rest.domain;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by damianijr on 19/05/17.
 */
public class ExchangeRate {

    private String symbol;
    private String name;
    private String description;
    private BigDecimal rate;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExchangeRate)) return false;
        ExchangeRate that = (ExchangeRate) o;
        return Objects.equals(getSymbol(), that.getSymbol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSymbol());
    }
}
