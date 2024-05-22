package com.implementaciondb.ejercicio7_empleados_elasticsearch.controller;

import com.implementaciondb.ejercicio7_empleados_elasticsearch.model.dto.EmployeeRequestDto;
import com.implementaciondb.ejercicio7_empleados_elasticsearch.model.dto.EmployeeResponseDto;
import com.implementaciondb.ejercicio7_empleados_elasticsearch.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeResponseDto> createEmployee(@RequestBody EmployeeRequestDto employee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.saveEmployee(employee));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDto>> getAllEmployees() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findEmployeeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> updateEmployee(
            @PathVariable String id,
            @RequestBody EmployeeRequestDto employee
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.updateEmployee(id, employee));
    }

}
