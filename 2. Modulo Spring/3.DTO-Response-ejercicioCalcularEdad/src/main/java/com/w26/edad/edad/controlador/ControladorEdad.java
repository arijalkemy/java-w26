package com.w26.edad.edad.controlador;

import com.w26.edad.edad.servicio.IServicioEdad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/edad")
public class ControladorEdad {
    @Autowired
    IServicioEdad servicioEdad;

    @GetMapping("/{dia}/{mes}/{ano}")
    public int getEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int ano) {
        return servicioEdad.calcularEdad(dia, mes, ano);
    }
}
