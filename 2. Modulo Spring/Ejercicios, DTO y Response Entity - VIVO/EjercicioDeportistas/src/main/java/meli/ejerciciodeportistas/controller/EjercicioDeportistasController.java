package meli.ejerciciodeportistas.controller;

import meli.ejerciciodeportistas.service.EjercicioDeportistasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class EjercicioDeportistasController {
    @Autowired
    EjercicioDeportistasService ejercicioDeportistas;
    @GetMapping("/findSports")
    public String decimalRomano(@PathVariable Integer numero){
        return ejercicioDeportistas.decimalRomano(numero);
    }
}
