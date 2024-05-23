package org.ejercicio.empleados.controller;

import org.ejercicio.empleados.dto.EmpleadoDto;
import org.ejercicio.empleados.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/empleado")
@RequiredArgsConstructor
public class EmpleadoController {
    @Autowired
    private final IEmpleadoService empleadoService;

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEmpleado(@PathVariable String id, @RequestBody EmpleadoDto empleadoDto) {
        return new ResponseEntity<>(empleadoService.actualizarEmpleado(id, empleadoDto), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> obtenerEmpleados() {
        return new ResponseEntity<>(empleadoService.obtenerEmpleados(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> crearEmpleado(@RequestBody EmpleadoDto empleado) {
        return new ResponseEntity<>(empleadoService.crearEmpleado(empleado), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerEmpleadoPorId(@PathVariable("id") String id) {
        return new ResponseEntity<>(empleadoService.obtenerEmpleadoPorId(id), HttpStatus.OK);
    }

}
