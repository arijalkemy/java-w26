package org.example.empleados.service;

import org.example.empleados.dto.EmployeeRequestDTO;
import org.example.empleados.dto.EmployeeResponseDTO;

import java.util.List;

public interface IEmployeeService {
    String createEmployee(EmployeeRequestDTO employeeRequestDTO);
    EmployeeResponseDTO updateEmployee(String id, EmployeeRequestDTO employeeRequestDTO);
    List<EmployeeResponseDTO> getAllEmployees();
}
