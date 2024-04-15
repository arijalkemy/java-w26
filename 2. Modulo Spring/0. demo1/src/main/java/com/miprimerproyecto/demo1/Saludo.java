package com.miprimerproyecto.demo1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Saludo {

    @GetMapping("/saludo/{nombre}")
    public String sayHello(@PathVariable String nombre){
        return "Hello " + nombre;

    }
}
