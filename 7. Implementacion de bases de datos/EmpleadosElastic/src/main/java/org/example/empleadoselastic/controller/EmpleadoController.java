package org.example.empleadoselastic.controller;

import org.example.empleadoselastic.dto.EmpleadoDTO;
import org.example.empleadoselastic.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EmpleadoController {

    @Autowired
    private IEmpleadoService empleadoService;

    @PostMapping("/")
    public ResponseEntity<?> saveEmpleado(@RequestBody EmpleadoDTO empleado) {
        return new ResponseEntity<>(empleadoService.saveEmpleado(empleado), HttpStatus.OK);
    }

}
