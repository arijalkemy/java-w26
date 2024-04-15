package com.example.creandoUnaAPI.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    @GetMapping("{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello: " + name;
    }
}
