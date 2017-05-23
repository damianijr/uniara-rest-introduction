package com.uniara.rest.service;

import com.uniara.rest.domain.ExchangeRate;
import com.uniara.rest.exceptions.AlreadyExistsException;
import com.uniara.rest.exceptions.NotFoundException;
import com.uniara.rest.repository.ExchangeRateRepository;
import com.uniara.rest.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Regras para cotação.
 */
@Service
public class ExchangeRateService {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    /**
     * Cria uma nova cotação.
     * @param exchangeRate Cotação.
     * @return true caso a cotação for persistida com sucesso, false caso contrário.
     * @throws AlreadyExistsException Caso uma cotaçao com o mesmo simbolo de moeda ja esteja cadastrada.
     */
    public void create(final ExchangeRate exchangeRate) throws AlreadyExistsException {
        if(this.exchangeRateRepository.exists(exchangeRate.getSymbol())) {
           throw new AlreadyExistsException();
        }
        exchangeRateRepository.save(exchangeRate);
    }

    /**
     * Atualiza uma cotação existente.
     * @param exchangeRate Cotação.
     * @throws NotFoundException Caso a cotação não existir.
     */
    public void update(ExchangeRate exchangeRate) throws NotFoundException {
        if(!this.exchangeRateRepository.exists(exchangeRate.getSymbol())) {
            throw new NotFoundException();
        }
        exchangeRateRepository.save(exchangeRate);
    }

    /**
     * Atualiza parte de uma cotação.
     * @param symbol Simbolo da moeda.
     * @param exchangeRate Cotação.
     * @throws NotFoundException Caso a cotação não existir.
     */
    public void update(String symbol, ExchangeRate exchangeRate) throws NotFoundException {
        if(!this.exchangeRateRepository.exists(symbol)) {
            throw new NotFoundException();
        }

        try {
            final ExchangeRate target = this.exchangeRateRepository.findBySymbol(symbol);
            new BeanUtil().copyProperties(target, exchangeRate);
            this.exchangeRateRepository.save(target);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Obtém as cotações cadastradas no sistema.
     * @return Cotações cadastradas no sistema.
     */
    public List<ExchangeRate> findAll() {
        return exchangeRateRepository.findAll();
    }

    /**
     * Obtém uma cotacão a partir do simbolo da moeda.
     * @param symbol Simbolo da moeda.
     * @return Cotação encontrada.
     * @throws NotFoundException Caso nenhuma cotação for encontrada.
     */
    public ExchangeRate findBySymbol(final String symbol) throws NotFoundException {
        if(!this.exchangeRateRepository.exists(symbol)) {
            throw new NotFoundException();
        }
        return this.exchangeRateRepository.findBySymbol(symbol);
    }

    /**
     * Remove uma cotação a partir do símbolo da moeda.
     * @param symbol Simbolo da moeda.
     * @return true caso a cotação for removida com sucesso, false caso contrário.
     * @throws NotFoundException Caso nenhuma cotação for encontrada.
     */
    public boolean deleteBySymbol(final String symbol) throws NotFoundException {
        if(!this.exchangeRateRepository.exists(symbol)) {
            throw new NotFoundException();
        }
        return this.exchangeRateRepository.deleteBySymbol(symbol);
    }

}
