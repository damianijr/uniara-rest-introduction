package com.uniara.rest.resource;

import com.uniara.rest.domain.ExchangeRate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by damianijr on 19/05/17.
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

}
