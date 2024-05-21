package com.example.empleadoses.controllers;

import com.example.empleadoses.domain.Empleado;
import com.example.empleadoses.repositories.EmpleadoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("empleado")
public class EmpleadoController {
    private final EmpleadoRepository empleadoRepository;

    public EmpleadoController(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @PostMapping("/new")
    public ResponseEntity<Empleado> post(@RequestBody Empleado empleado) {
        Empleado empleado1 = empleadoRepository.save(empleado);
        return ResponseEntity.ok(empleado1);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Empleado>> getAll() {
        return ResponseEntity.ok(empleadoRepository.findAll());
    }
}
