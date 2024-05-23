package org.example.elasticksearch.controller;

import org.example.elasticksearch.domain.Empleado;
import org.example.elasticksearch.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    @Autowired
    IEmpleadoService empleadoService;

    @PostMapping("/new")
    ResponseEntity<?> createEmpleado(@RequestBody Empleado empleado) {
        Empleado nuevoEmpleado = empleadoService.createEmpleado(empleado);
        return ResponseEntity.ok(nuevoEmpleado);
    }
}

