package org.example.empleados.controller;

import org.example.empleados.model.dto.EmpleadoRequestDTO;
import org.example.empleados.model.dto.EmpleadoResponseDTO;
import org.example.empleados.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    IEmpleadoService service;

    @PostMapping("/new")
    public ResponseEntity<EmpleadoResponseDTO> create(@RequestBody EmpleadoRequestDTO empleado) {
        return ResponseEntity.ok(service.create(empleado));
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmpleadoResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
