package org.ejercicio.empleados.controllers;

import org.ejercicio.empleados.dtos.EmpleadoDto;
import org.ejercicio.empleados.models.Empleado;
import org.ejercicio.empleados.services.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import java.util.*;

@RestController
@RequestMapping("/empleado")
@RequiredArgsConstructor
public class EmpleadoController {
    @Autowired
    private final IEmpleadoService empleadoService;

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEmpleado(@PathVariable String id, @RequestBody EmpleadoDto empleadoDto) {
        return ResponseEntity.status(200).body(empleadoService.actualizarEmpleado(id, empleadoDto));
    }

    @GetMapping("/")
    public ResponseEntity<?> obtenerEmpleados() {
        return ResponseEntity.status(200).body(empleadoService.obtenerEmpleados());
    }

    @PostMapping("/")
    public ResponseEntity<?> crearEmpleado(@RequestBody EmpleadoDto empleado) {
        return ResponseEntity.status(201).body(empleadoService.crearEmpleado(empleado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerEmpleadoPorId(@PathVariable("id") String id) {
        return ResponseEntity.status(201).body(empleadoService.obtenerEmpleadoPorId(id));
    }

}
