package com.mercadolibre.sprint3_individual_perez.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DemoController {

    @GetMapping("/demo")
    public String index(){
        return "Welcome from secure endpoint 1";
    }

    @GetMapping("/demoAdmin")
    public String indexAdmin(){
        return "Welcome from secure endpointAdmin 1";
    }

    @GetMapping("/index2")
    public String index2(){
        return "Welcome from a Not SECURED endpoint!";
    }
}
