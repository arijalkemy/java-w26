package org.bootcamp.implementacionnosql.controller;

import org.bootcamp.implementacionnosql.dto.EmployeeDTO;
import org.bootcamp.implementacionnosql.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;

    @PostMapping
    ResponseEntity<?> createEmployee(@RequestBody EmployeeDTO employee) {
        return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateEmployee(@PathVariable String id, @RequestBody EmployeeDTO employee) {
        return new ResponseEntity<>(employeeService.updateEmployee(id, employee), HttpStatus.OK);
    }
}
