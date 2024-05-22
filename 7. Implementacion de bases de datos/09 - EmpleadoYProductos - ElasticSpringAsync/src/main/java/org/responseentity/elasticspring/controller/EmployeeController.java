package org.responseentity.elasticspring.controller;

import org.responseentity.elasticspring.dto.request.EmployeeRequestDto;
import org.responseentity.elasticspring.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;

    @PostMapping()
    public ResponseEntity<?> postEmployee(@RequestBody EmployeeRequestDto employeeRequestDto){
        return new ResponseEntity<>(iEmployeeService.addEmployee(employeeRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putEmployee(@PathVariable String id,
                                         @RequestBody EmployeeRequestDto employeeRequestDto){
        return new ResponseEntity<>(iEmployeeService.editEmployee(id, employeeRequestDto), HttpStatus.OK);
    }

}
