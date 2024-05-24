package org.example.empleados.controllers;

import org.example.empleados.models.DTO.EmployeeRequestDTO;
import org.example.empleados.models.DTO.EmployeeResponseDTO;
import org.example.empleados.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/empleados")
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @PostMapping("/new")
    ResponseEntity<EmployeeResponseDTO> postEmpleado(@RequestBody EmployeeRequestDTO empleado){
        return new ResponseEntity<>(employeeService.createNew(empleado), HttpStatus.CREATED);
    }

    @GetMapping()
    ResponseEntity<List<EmployeeResponseDTO>> getAll(){
        return new ResponseEntity<>(employeeService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<EmployeeResponseDTO> getById(@PathVariable String id){
        return new ResponseEntity<>(employeeService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<EmployeeResponseDTO> updateById(@PathVariable String id, @RequestBody EmployeeRequestDTO empleado){
        return new ResponseEntity<>(employeeService.updateEmployeeById(id,empleado),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteById( @PathVariable String id){
        return new ResponseEntity<>(employeeService.deleteEmployee(id),HttpStatus.OK);
    }

    @GetMapping(params = "depto")
    ResponseEntity<List<EmployeeResponseDTO>> getAllByDpto(@RequestParam String depto){
        return new ResponseEntity<>(employeeService.findEmployeeByDepto(depto), HttpStatus.OK);
    }
}
