package org.miprimerproyecto.elasticempleado.controller;

import org.miprimerproyecto.elasticempleado.entities.Employee;
import org.miprimerproyecto.elasticempleado.service.impl.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class employeeController {
    
    @Autowired
    private employeeService employeeService;

    @GetMapping("/list")
    public String list(){
        return employeeService.findAll().toString();
    }

    @PostMapping("/save")
    public String save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @PostMapping("/update")
    public String update(@RequestBody Employee employee){
        return employeeService.save(employee);
    }
}
