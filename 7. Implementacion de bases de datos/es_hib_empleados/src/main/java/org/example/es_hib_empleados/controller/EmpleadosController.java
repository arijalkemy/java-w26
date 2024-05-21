package org.example.es_hib_empleados.controller;

import org.example.es_hib_empleados.dtos.EmpleadoDto;
import org.example.es_hib_empleados.dtos.EmpleadoResDto;
import org.example.es_hib_empleados.dtos.MessageDto;
import org.example.es_hib_empleados.model.Empleado;
import org.example.es_hib_empleados.service.interfaces.IEmpleadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmpleadosController {
    private final IEmpleadoService service;

    public EmpleadosController(IEmpleadoService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Empleado>> getAllEmpleados() {
        List<Empleado> empleadoList = service.getAllEmpleados();
        return ResponseEntity.ok(empleadoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoResDto> getById(@PathVariable String id) {
        EmpleadoResDto foundEmpleado = service.findById(id);
        return ResponseEntity.ok(foundEmpleado);
    }

    @PostMapping("/new")
    public ResponseEntity<EmpleadoResDto> createEmpleado(
            @RequestBody EmpleadoDto empleadoDto
    ){
        EmpleadoResDto createdEmpleado = service.create(empleadoDto);
        return new ResponseEntity<>(createdEmpleado, HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<EmpleadoResDto> updateEmpleado(
            @RequestBody EmpleadoDto empleadoDto,
            @PathVariable String id
    ){
        EmpleadoResDto updatedEmpleado = service.update(id, empleadoDto);
        return new ResponseEntity<>(updatedEmpleado, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<MessageDto> deleteEmpleado(@PathVariable String id){
        MessageDto messageDto = service.delete(id);
        return ResponseEntity.ok(messageDto);
    }
}
