package com.miprimerproyecto.prueba.controladores;

import com.miprimerproyecto.prueba.servicios.IRomano;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/{decimal}")
public class DecimalesARomanos {
    @Autowired
    IRomano romanoService;

    @GetMapping
    public String pasarARomano(@PathVariable int decimal){

        return "El valor " + decimal +" en romano es " + romanoService.obtenerResultadoEnRomano(decimal);
    }
}
