package com.example.empleados_spring_data_elastic.controller;

import com.example.empleados_spring_data_elastic.domain.Empleado;
import com.example.empleados_spring_data_elastic.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/")
    public ResponseEntity<?> getAllEmployees() {
        return new ResponseEntity<>(empleadoService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/saveEmpleado")
    public ResponseEntity<?> saveEmployee(@RequestBody Empleado empleado) {
        return new ResponseEntity<>(empleadoService.save(empleado), HttpStatus.OK);
    }
}
