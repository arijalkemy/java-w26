package com.w26.elasticsearch.elasticsearch.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.w26.elasticsearch.elasticsearch.dto.EmployeeDTO;
import com.w26.elasticsearch.elasticsearch.service.interfaces.IEmployeeService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
    @Autowired
    IEmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<?> getEmployees() {
        return ResponseEntity.ok().body(employeeService.getAllEmployee());
    }

    @PostMapping("")
    public ResponseEntity<?> postEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employeeDTO));
    }
 
    @PutMapping("{id}")
    public ResponseEntity<?> putEmployee(@PathVariable String id , @Valid @RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.updateEmployee(id, employeeDTO));
    }

    
}
