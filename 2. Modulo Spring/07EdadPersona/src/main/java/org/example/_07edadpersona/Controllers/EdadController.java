package org.example._07edadpersona.Controllers;

import org.example._07edadpersona.Services.IEdadDesdeFechaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EdadController {

    @Autowired
    IEdadDesdeFechaService edadDesdeFechaService;

    @GetMapping("/{dia}/{mes}/{anio}")
    public ResponseEntity<String> getEdadPersona(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        int resultado = edadDesdeFechaService.calcular(dia, mes, anio);
        if (resultado == -1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La fecha ingresada es incorrecta");
        }
        return ResponseEntity.status(HttpStatus.OK).body(String.valueOf(resultado));
    }
}
