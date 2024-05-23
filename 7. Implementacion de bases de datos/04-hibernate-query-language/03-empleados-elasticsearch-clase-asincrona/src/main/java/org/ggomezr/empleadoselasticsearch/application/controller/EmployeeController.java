package org.ggomezr.empleadoselasticsearch.application.controller;

import org.ggomezr.empleadoselasticsearch.application.service.impl.EmployeeService;
import org.ggomezr.empleadoselasticsearch.domain.dto.EmployeeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("create")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        return new ResponseEntity<>(employeeService.createEmployee(employeeDTO), HttpStatus.CREATED);
    }

    @PostMapping("create/bulk")
    public ResponseEntity<?> createEmployees(@RequestBody List<EmployeeDTO> employeesDTO){
        return new ResponseEntity<>(employeeService.createEmployees(employeesDTO), HttpStatus.CREATED);
    }

    @GetMapping("all")
    public ResponseEntity<?> getAllEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable String id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable String id, @RequestBody EmployeeDTO employeeDTO){
        return new ResponseEntity<>(employeeService.updateEmployee(id, employeeDTO), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
