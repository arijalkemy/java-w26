package org.example.integradorproductemployee.service;

import org.example.integradorproductemployee.entity.dto.EmployeeDTO;
import org.example.integradorproductemployee.entity.dto.EmployeeUtilDTO;

import java.util.List;

public interface IEmployeeService {

    List<EmployeeUtilDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(String id);
    void createEmployee(EmployeeDTO employeeDTO);
    void updateEmployee(EmployeeUtilDTO employeeUtilDTO);



}
