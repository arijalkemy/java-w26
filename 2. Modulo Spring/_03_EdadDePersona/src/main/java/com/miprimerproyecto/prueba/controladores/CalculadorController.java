package com.miprimerproyecto.prueba.controladores;

import com.miprimerproyecto.prueba.servicios.ICalculable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class CalculadorController {
    @Autowired
    ICalculable iCalculable;

    @GetMapping("/{dia}/{mes}/{anio}")
    public int pasarARomano(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio ){

        return iCalculable.obtenerEdad(dia, mes, anio);
    }
}
