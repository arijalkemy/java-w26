package com.meli.calcularedadejerciciopractico.Controlador;

import com.meli.calcularedadejerciciopractico.Service.ICalcularEdad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/calcularEdad")
public class CalcularEdadControlador {
    @Autowired
    ICalcularEdad calcularEdadService;


    @GetMapping()
    public String calcularEdad(@RequestParam("fechaNacimiento") LocalDate fechaNacimiento)
    {
        return calcularEdadService.calcularEdad(fechaNacimiento);
    }

}
