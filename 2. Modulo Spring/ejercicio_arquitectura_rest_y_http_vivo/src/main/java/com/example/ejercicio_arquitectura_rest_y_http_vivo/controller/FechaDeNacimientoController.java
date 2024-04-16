package com.example.ejercicio_arquitectura_rest_y_http_vivo.controller;

import com.example.ejercicio_arquitectura_rest_y_http_vivo.service.IFechaDeNacimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class FechaDeNacimientoController {
    @Autowired
    private IFechaDeNacimientoService fechaDeNacimientoService;

    @GetMapping("/{dia}/{mes}/{anio}")
    public Integer obtenerEdad(
            @PathVariable Integer dia,
            @PathVariable Integer mes,
            @PathVariable Integer anio
    ) {
        return fechaDeNacimientoService.calcularEdad(dia, mes, anio);
    }
}
