package com.mercadolibre.Empleados_NOSQL.controller;

import com.mercadolibre.Empleados_NOSQL.dto.EmpleadoRequestDto;
import com.mercadolibre.Empleados_NOSQL.dto.EmpleadoResponseDto;
import com.mercadolibre.Empleados_NOSQL.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    IEmpleadoService service;

    @GetMapping("")
    public ResponseEntity<List<EmpleadoResponseDto>> getAllEmpleados(){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.getAllEmpleados());
    }

    @PostMapping("")
    public ResponseEntity<EmpleadoResponseDto> saveEmpleado(@RequestBody EmpleadoRequestDto empleado){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveEmpleado(empleado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoResponseDto> updateEmpleado
            (@PathVariable String id, @RequestBody EmpleadoRequestDto empleado){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateEmpleado(id,empleado));
    }

}
