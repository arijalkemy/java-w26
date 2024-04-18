package com.spring.calculoedad.Controllers;

import com.spring.calculoedad.Services.EdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class EdadController {

    @Autowired
    EdadService edadService;

    @GetMapping("/calcular/{dia}/{mes}/{anio}")
    public int calcularEdad(@PathVariable int dia,@PathVariable int mes,@PathVariable int anio){
        return edadService.calcularEdad(dia,mes,anio);
    }

}
