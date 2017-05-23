package com.uniara.rest.repository;

import com.uniara.rest.domain.ExchangeRate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Repositório de cotações (em memória).
 */
@Repository
public class ExchangeRateRepository {

    /**
     * Armazena as cotações.
     */
    private List<ExchangeRate> exchangeRateList =  new ArrayList<>();

    /**
     * Persiste uma nova cotação ou atualiza caso a mesma já estiver cadastrada.
     * @param exchangeRate Cotação.
     * @return true caso a cotação for persistida com sucesso, false caso contrário.
     */
    public boolean save(final ExchangeRate exchangeRate) {
        this.exchangeRateList.remove(exchangeRate);
        return this.exchangeRateList.add(exchangeRate);
    }

    /**
     * Obtém as cotações cadastradas no sistema.
     * @return Cotações cadastradas no sistema.
     */
    public List<ExchangeRate> findAll() {
        return this.exchangeRateList;
    }


    /**
     * Obtém uma cotacão a partir do simbolo da moeda.
     * @param symbol Simbolo da moeda.
     * @return Cotação encontrada ou null caso nenhuma cotação for encontrada.
     */
    public ExchangeRate findBySymbol(final String symbol) {
        final ExchangeRate exchangeRate = new ExchangeRate(symbol);
        if (!this.exchangeRateList.contains(exchangeRate)) {
            return null;
        }
        return this.exchangeRateList.get(this.exchangeRateList.indexOf(exchangeRate));
    }


    /**
     * Remove uma cotação a partir do símbolo da moeda.
     * @param symbol Simbolo da moeda.
     * @return true caso a cotação for removida com sucesso, false caso contrário.
     */
    public boolean deleteBySymbol(final String symbol) {
        final ExchangeRate exchangeRate = new ExchangeRate(symbol);
        return this.exchangeRateList.remove(exchangeRate);
    }

    /**
     * Verifica se existe uma cotação cadastrada a partir do simbolo informado.
     * @param symbol Simbolo da moeda.
     * @return Cotação encontrada ou null caso nenhuma cotação for encontrada.
     */
    public boolean exists(final String symbol) {
        final ExchangeRate exchangeRate = new ExchangeRate(symbol);
        return this.exchangeRateList.contains(exchangeRate);
    }
}
