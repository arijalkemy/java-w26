package com.meli.Empleados.controller;

import com.meli.Empleados.dto.EmpleadoDto;
import com.meli.Empleados.model.Empleado;
import com.meli.Empleados.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping("/")
    public ResponseEntity<EmpleadoDto> create(@RequestBody EmpleadoDto empleado){
        return new ResponseEntity<>(empleadoService.create(empleado), HttpStatus.CREATED);
    }
}
