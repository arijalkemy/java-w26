package com.sinc_edaddeunapersona.controlador;

import com.sinc_edaddeunapersona.servicio.IEdadPersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personaEdad")
public class EdadPersonaControlador {
    @Autowired
    private IEdadPersonaServicio edadPersonaServicio;

    @GetMapping(path = "/{dia}/{mes}/{anio}")
    public Integer calcularEdad(@PathVariable Integer dia,
                                @PathVariable Integer mes,
                                @PathVariable Integer anio) {
        return edadPersonaServicio.calcularEdad(dia, mes, anio);
    }

    //prueba
    //localhost:8080/personaEdad/25/07/1999
}
