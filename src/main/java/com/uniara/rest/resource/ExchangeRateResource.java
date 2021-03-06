package com.uniara.rest.resource;

import com.uniara.rest.domain.ExchangeRate;
import com.uniara.rest.exceptions.AlreadyExistsException;
import com.uniara.rest.exceptions.NotFoundException;
import com.uniara.rest.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Endpoint de cotações.
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/exchangerate")
public class ExchangeRateResource {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @PostMapping(consumes = "application/json")
    public void add(@RequestBody final ExchangeRate exchangeRate) throws AlreadyExistsException {
        this.exchangeRateService.create(exchangeRate);
    }

    @PutMapping(value = "/{symbol}", consumes = "application/json")
    public void edit(@RequestBody final ExchangeRate exchangeRate) throws NotFoundException {
        this.exchangeRateService.update(exchangeRate);
    }

    @PatchMapping(value = "/{symbol}", consumes = "application/json")
    public void update(@PathVariable final String symbol, @RequestBody final ExchangeRate exchangeRate) throws NotFoundException {
        this.exchangeRateService.update(symbol, exchangeRate);
    }

    @GetMapping
    public List<ExchangeRate> list() { return this.exchangeRateService.findAll(); }

    @GetMapping("/{symbol}")
    public ExchangeRate show(@PathVariable final String symbol) throws NotFoundException { return this.exchangeRateService.findBySymbol(symbol); }

    @DeleteMapping("/{symbol}")
    public void delete(@PathVariable final String symbol) throws NotFoundException { this.exchangeRateService.deleteBySymbol(symbol); }

}
