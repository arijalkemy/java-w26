package com.example.ejercicio_implementacion_nosql_empleados.controller;

import com.example.ejercicio_implementacion_nosql_empleados.model.domain.Empleado;
import com.example.ejercicio_implementacion_nosql_empleados.model.dto.request.CreateEmpleadoRequestDto;
import com.example.ejercicio_implementacion_nosql_empleados.model.dto.request.UpdateEmpleadoRequestDto;
import com.example.ejercicio_implementacion_nosql_empleados.model.dto.response.EmpleadoResponseDto;
import com.example.ejercicio_implementacion_nosql_empleados.service.IEmpleadoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("empleados")
public class EmpleadoController {
    private final IEmpleadoService empleadoService;

    @GetMapping("")
    public ResponseEntity<List<EmpleadoResponseDto>> getAllEmpleados() {
        return new ResponseEntity<>(
            empleadoService.searchAllEmpleados(),
            HttpStatus.OK
        );
    }

    @PostMapping("")
    public ResponseEntity<EmpleadoResponseDto> createEmpleado(
        @RequestBody CreateEmpleadoRequestDto createEmpleadoRequestDto
    ) {
        return new ResponseEntity<>(
            empleadoService.createEmpleado(createEmpleadoRequestDto),
            HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoResponseDto> updateEmpleado(
        @PathVariable Long id,
        @RequestBody UpdateEmpleadoRequestDto updateEmpleadoRequestDto
    ) {
        return new ResponseEntity<>(
            empleadoService.updateEmpleado(id, updateEmpleadoRequestDto),
            HttpStatus.OK
        );
    }
}
