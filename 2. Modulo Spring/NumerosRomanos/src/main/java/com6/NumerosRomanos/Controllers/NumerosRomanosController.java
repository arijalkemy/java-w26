package com6.NumerosRomanos.Controllers;

import com6.NumerosRomanos.Services.IConversorRomano;
import com6.NumerosRomanos.Services.IPresentadorDeNumeros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/numeros")
public class NumerosRomanosController {

    @Autowired
    IConversorRomano conversorRomano;

    @Autowired
    IPresentadorDeNumeros presentadorDeNumeros;

    @GetMapping("/{numero}")
    public String convertirARomano(@PathVariable int numero) {
        return presentadorDeNumeros.presentar(numero, conversorRomano.convertirEnteroARomano(numero));
    }
}
