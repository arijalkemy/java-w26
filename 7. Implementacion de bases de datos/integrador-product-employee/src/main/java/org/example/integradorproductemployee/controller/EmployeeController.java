package org.example.integradorproductemployee.controller;


import lombok.RequiredArgsConstructor;
import org.example.integradorproductemployee.entity.dto.EmployeeDTO;
import org.example.integradorproductemployee.entity.dto.EmployeeUtilDTO;
import org.example.integradorproductemployee.service.IEmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final IEmployeeService employeeService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getEmployeeById(@PathVariable String id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        employeeService.createEmployee(employeeDTO);
        return ResponseEntity.ok("Created");
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeUtilDTO employeeUtilDTO){
        employeeService.updateEmployee(employeeUtilDTO);
        return ResponseEntity.ok("Updated");
    }




}
