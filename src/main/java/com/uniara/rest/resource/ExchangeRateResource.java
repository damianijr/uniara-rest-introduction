package com.uniara.rest.resource;

import com.uniara.rest.domain.ExchangeRate;
import com.uniara.rest.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by damianijr on 19/05/17.
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/exchangerate")
public class ExchangeRateResource {


    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @PostMapping(consumes = "application/json")
    public void add(@RequestBody final ExchangeRate exchangeRate) {
        this.exchangeRateRepository.save(exchangeRate);
    }

    @PutMapping(value = "/{symbol}", consumes = "application/json")
    public void edit(@RequestBody final ExchangeRate exchangeRate) {
        this.exchangeRateRepository.save(exchangeRate);
    }

    @GetMapping
    public List<ExchangeRate> list() {
        return this.exchangeRateRepository.findAll();
    }

    @GetMapping("/{symbol}")
    public ExchangeRate show(@PathVariable final String symbol) { return this.exchangeRateRepository.findBySymbol(symbol); }

    @DeleteMapping("/{symbol}")
    public void delete(@PathVariable final String symbol) {
        this.exchangeRateRepository.deleteBySymbol(symbol);
    }

}
