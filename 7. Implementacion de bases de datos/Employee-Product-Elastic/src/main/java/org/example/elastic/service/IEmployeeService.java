package org.example.elastic.service;

import org.example.elastic.dto.employee.EmployeeRequestDto;
import org.example.elastic.dto.employee.EmployeeResponseDto;

public interface IEmployeeService {
    EmployeeResponseDto getEmployeeById(String id);

    EmployeeResponseDto createEmployee(EmployeeRequestDto employeeRequestDto);

    EmployeeResponseDto updateEmployee(String id, EmployeeRequestDto employeeDto);
}
