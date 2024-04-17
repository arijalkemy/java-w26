package org.example.edadpersona.controller;

import org.example.edadpersona.service.IEdadPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/edad")
public class EdadController {

    @Autowired
    IEdadPersonaService edadPersonaService;

@GetMapping("/calcular/{anioNacimiento}/{mesNacimiento}/{diaNacimiento}")
    public int calcularEdad(@PathVariable int anioNacimiento,@PathVariable int mesNacimiento, @PathVariable int diaNacimiento) {
        return edadPersonaService.calcularEdad(anioNacimiento, mesNacimiento, diaNacimiento);
    }


}
