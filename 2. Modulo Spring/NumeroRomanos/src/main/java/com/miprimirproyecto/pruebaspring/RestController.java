package com.miprimirproyecto.pruebaspring;

import com.miprimirproyecto.pruebaspring.Clases.NumeroRomano;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/{name}")
    public String sayHello(@PathVariable String name){
        return "Hello Wolrd" + name;
    }


    @GetMapping("numeroRomano/{nroRomano}")
    public String nunmeroRomano(@PathVariable Integer nroRomano)
    {
        NumeroRomano numeroRomano = new NumeroRomano();

        return numeroRomano.convertirNumeroARomano(nroRomano);
    }

}
