package org.edadpersona.controller;

import org.edadpersona.service.EdadPersonaService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadPersonaController {

    @Autowired
    EdadPersonaService edadPersona;
    @GetMapping("/{dia}/{mes}/{year}")
    public Integer edadPersona(@PathVariable @NotNull Integer dia, @PathVariable @NotNull Integer mes, @PathVariable @NotNull Integer year){
        if(mes< 1 || mes > 12) {
            throw new IllegalArgumentException("Mes incorrecto, debe ser entre 1 y 12");
        }
        if(dia < 1 || dia > 31) {
            throw new IllegalArgumentException("Dia incorrecto, debe ser entre 1 y 31");
        }
        return edadPersona.calcularEdadPersona(dia,mes,year);
    }
}
