package com.bootcamp.employees.service;

import com.bootcamp.employees.dto.EmployeeDTO;
import com.bootcamp.employees.dto.ResponseDTO;

import java.util.List;

public interface IEmployeeService {

    List<EmployeeDTO> getAlls();

    EmployeeDTO getEmployeeById(String id);

    ResponseDTO create (EmployeeDTO employeeDTO);

    ResponseDTO update (String id, EmployeeDTO employeeDTO);

    void delete (String id);

}
