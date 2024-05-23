package com.demospring.ejerciciodeempleados.controller;

import com.demospring.ejerciciodeempleados.dto.request.EmpleadoDTO;
import com.demospring.ejerciciodeempleados.model.Empleado;
import com.demospring.ejerciciodeempleados.service.IServiceEmpleado;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleados")
@AllArgsConstructor
public class EmpleadoController {
    private final IServiceEmpleado iServiceEmpleado;

    @GetMapping
    public ResponseEntity<?> obtenerEmpleados() {
        return ResponseEntity.ok(iServiceEmpleado.obtenerEmpleados());
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearEmpleado(@RequestBody Empleado empleado) {
        iServiceEmpleado.crearEmpleado(empleado);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }
}
