package com.example.elasticsearchempleadoproducto.controller;

import com.example.elasticsearchempleadoproducto.dto.EmpleadoDto;
import com.example.elasticsearchempleadoproducto.service.IEmpleadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    private final IEmpleadoService empleadoService;

    public EmpleadoController(IEmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping()
    public ResponseEntity<?> getEmpleados() {
        return ResponseEntity.ok().body(empleadoService.getAllEmpleados());
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody EmpleadoDto empleadoDto) {
        return ResponseEntity.ok(empleadoService.crearEmpleado(empleadoDto));
    }
}
