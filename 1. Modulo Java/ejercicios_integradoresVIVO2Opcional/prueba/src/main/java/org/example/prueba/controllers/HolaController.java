package org.example.prueba.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {
    @GetMapping
    public String sayHello(){
        return "Hola";
    }
    @GetMapping("/{name}")
    public String sayHello(@PathVariable String name){
        return "Hola " + name;
    }
    @GetMapping("/numeroRomano/{numero}")
    public String numeroRomano(@PathVariable Integer numero){
        String numeroRomano ="";
        int cociente = numero/1000;
        numeroRomano = "M".repeat(cociente);
        numero-=1000*cociente;
        if(numero > 500){

        }
        cociente = numero/500;
        numeroRomano += "D".repeat(cociente);
        numero-=500*cociente;
        cociente = numero/100;
        numeroRomano +=  "C".repeat(cociente);
        numero-=100*cociente;
        cociente = numero/50;
        numeroRomano += "L".repeat(cociente);
        numero-=50*cociente;
        cociente = numero/10;
        numeroRomano +=  "X".repeat(cociente);
        numero-=10*cociente;
        cociente = numero/5;
        numeroRomano += "V".repeat(cociente);
        numero-=5*cociente;
        numeroRomano += "I".repeat(numero);
        return numeroRomano;
    }
}
