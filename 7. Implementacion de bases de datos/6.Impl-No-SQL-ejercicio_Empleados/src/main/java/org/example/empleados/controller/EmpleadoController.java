package org.example.empleados.controller;

import org.example.empleados.dto.EmpleadoDto;
import org.example.empleados.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    IEmpleadoService empleadoService;

    @PostMapping
    public ResponseEntity<String> postEmpleado(@RequestBody EmpleadoDto empleadoDto) {
        empleadoService.crearEmpleado(empleadoDto);
        return ResponseEntity.status(HttpStatus.OK).body("empleado creado con exito");
    }

    // SE PUEDE EDITAR AL EMPLEDAO DESDE EL ENDPOINT DE POST, IGUALMENTE SE IMPLEMENTA PUT
    @PutMapping
    public ResponseEntity<String> updateEmpleado(@RequestBody EmpleadoDto empleadoDto) {
        empleadoService.editarEmpleado(empleadoDto);
        return ResponseEntity.status(HttpStatus.OK).body("empleado actualizado con exito");
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoDto>> getAllEmpleados() {
        return ResponseEntity.status(HttpStatus.OK).body(empleadoService.findAllEmpleados());
    }

}
