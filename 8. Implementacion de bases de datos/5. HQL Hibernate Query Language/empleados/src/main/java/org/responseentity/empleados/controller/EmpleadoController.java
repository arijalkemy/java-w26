package org.responseentity.empleados.controller;

import org.apache.http.protocol.HTTP;
import org.responseentity.empleados.dto.EmpleadoDTO;
import org.responseentity.empleados.service.EmpleadoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    EmpleadoServiceImpl empleadoService;

    @GetMapping
    public ResponseEntity<?> listAllEmpleados(){
        return new ResponseEntity<>(empleadoService.listAllEmpleados(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") String id){
        return new ResponseEntity<>(empleadoService.getEmpleadoById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveEmpleado(@RequestBody EmpleadoDTO empleadoDTO){
        return new ResponseEntity<>(empleadoService.saveEmpleado(empleadoDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmpleado(@PathVariable("id") String id, @RequestBody EmpleadoDTO empleadoDTO){
        return new ResponseEntity<>(empleadoService.updateEmpleado(id, empleadoDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmpleado(@PathVariable("id") String id){
        empleadoService.deleteEmpleado(id);
        return new ResponseEntity<>("Empleado eliminado", HttpStatus.OK);
    }

}
