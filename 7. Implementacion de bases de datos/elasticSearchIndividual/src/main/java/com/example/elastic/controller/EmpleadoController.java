package com.example.elastic.controller;

import com.example.elastic.model.Empleado;
import com.example.elastic.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    IEmpleadoService empleadoService;

    @PostMapping
    public ResponseEntity<Integer> createEmpleado(@RequestBody Empleado empleado) {
        return new ResponseEntity(empleadoService.save(empleado), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Empleado> editEmpleado(@RequestBody Empleado empleado) {
        return new ResponseEntity(empleadoService.editEmpleado(empleado), HttpStatus.OK);
    }
}
