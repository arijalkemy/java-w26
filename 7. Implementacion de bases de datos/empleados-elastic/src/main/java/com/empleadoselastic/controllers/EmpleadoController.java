package com.empleadoselastic.controllers;

import com.empleadoselastic.DTOs.EmpleadoRequestDTO;
import com.empleadoselastic.exception.EmpleadoNotFound;
import com.empleadoselastic.services.impl.EmpleadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @PostMapping
    public ResponseEntity<?> guardarEmpleado(
            @RequestBody EmpleadoRequestDTO empleadoRequestDTO
    ) {
        return new ResponseEntity<>(
                this.empleadoService.crear(empleadoRequestDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<?> getEmpleados() {
        return new ResponseEntity<>(
                this.empleadoService.getEmpleados(),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEmpleado(
            @PathVariable String id,
            @RequestBody EmpleadoRequestDTO empleadoRequestDTO
    ) {
        return new ResponseEntity<>(
                this.empleadoService.actualizar(id,empleadoRequestDTO),
                HttpStatus.OK
        );
    }

    @ExceptionHandler(EmpleadoNotFound.class)
    public ResponseEntity<?> handleEmpleadoNotFound(EmpleadoNotFound ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }


}
