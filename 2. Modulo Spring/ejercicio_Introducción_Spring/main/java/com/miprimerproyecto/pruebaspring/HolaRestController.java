package com.miprimerproyecto.pruebaspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaRestController {
    @GetMapping("/{name}")
    public String SayHello(@PathVariable String name){
        return "Hello World: " + name;
    }
}
