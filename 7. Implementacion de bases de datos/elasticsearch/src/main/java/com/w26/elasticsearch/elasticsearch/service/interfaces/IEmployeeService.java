package com.w26.elasticsearch.elasticsearch.service.interfaces;

import java.util.List;

import com.w26.elasticsearch.elasticsearch.dto.EmployeeDTO;
import com.w26.elasticsearch.elasticsearch.entity.Employee;

public interface IEmployeeService {

    public List<Employee> getAllEmployee();

    public String  createEmployee(EmployeeDTO product);
    public Boolean updateEmployee(String id, EmployeeDTO product);

}
