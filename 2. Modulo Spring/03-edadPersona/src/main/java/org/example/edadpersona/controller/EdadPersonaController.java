package org.example.edadpersona.controller;

import org.example.edadpersona.service.IEdadPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/edad")
public class EdadPersonaController {

    @Autowired
    IEdadPersonaService edadPersonaService;

    @GetMapping("/{dia}/{mes}/{anio}")
    public int convertirCodigoMorseATexto(@PathVariable int dia,
                                             @PathVariable int mes,
                                             @PathVariable int anio) {
        return edadPersonaService.calcularEdad(dia, mes, anio);
    }
}
