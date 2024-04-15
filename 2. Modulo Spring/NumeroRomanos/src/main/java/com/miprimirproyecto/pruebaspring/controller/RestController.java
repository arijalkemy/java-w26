package com.miprimirproyecto.pruebaspring.controller;

import com.miprimirproyecto.pruebaspring.Clases.NumeroRomano;
import com.miprimirproyecto.pruebaspring.services.ISaludosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/Saludo")
class RestController {


    @Autowired
    ISaludosService saludosService;
    @GetMapping("/{name}")
    public String sayHello(@PathVariable String name){
       return  saludosService.saludar(name);
    }


    @GetMapping("numeroRomano/{nroRomano}")
    public String nunmeroRomano(@PathVariable Integer nroRomano)
    {
        NumeroRomano numeroRomano = new NumeroRomano();


        return numeroRomano.convertirNumeroARomano(nroRomano);
    }

}
