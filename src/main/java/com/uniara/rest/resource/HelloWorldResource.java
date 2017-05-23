package com.uniara.rest.resource;

import com.uniara.rest.domain.ExchangeRate;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * Endpoint para testes de serviços.
 */
@RestController
@RequestMapping("/helloWorld")
public class HelloWorldResource {


    @GetMapping
    public String hello() {
        return "Meu primeio serviço rest";
    }


    @GetMapping("/exchange")
    public ExchangeRate exchange() {
        return new ExchangeRate();
    }

    @GetMapping("/exchange/{symbol}")
    public String exchangePathParam(@PathVariable final String symbol) {
        return "PathParam Symbol:" + symbol;
    }

    @GetMapping("/exchangeRequestParam")
    public String exchangeRequestParam(@RequestParam final String symbol) {
        return "RequestParam Symbol:" + symbol;
    }
}
