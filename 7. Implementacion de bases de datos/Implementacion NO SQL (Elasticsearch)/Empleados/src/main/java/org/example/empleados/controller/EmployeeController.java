package org.example.empleados.controller;

import lombok.RequiredArgsConstructor;
import org.example.empleados.dto.EmployeeRequestDTO;
import org.example.empleados.service.IEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final IEmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
        return new ResponseEntity<>(
                employeeService.createEmployee(employeeRequestDTO),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<?> editEmployee(
            @PathVariable("id") String id,
            @RequestBody EmployeeRequestDTO employeeRequestDTO
    ) {
        return new ResponseEntity<>(
                employeeService.updateEmployee(id, employeeRequestDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/list")
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(
                employeeService.getAllEmployees(),
                HttpStatus.OK
        );
    }
}
