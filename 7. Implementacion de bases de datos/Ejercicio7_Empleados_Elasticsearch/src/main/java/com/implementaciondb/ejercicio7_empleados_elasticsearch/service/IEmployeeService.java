package com.implementaciondb.ejercicio7_empleados_elasticsearch.service;

import com.implementaciondb.ejercicio7_empleados_elasticsearch.model.dto.EmployeeRequestDto;
import com.implementaciondb.ejercicio7_empleados_elasticsearch.model.dto.EmployeeResponseDto;

import java.util.List;

public interface IEmployeeService {
    EmployeeResponseDto saveEmployee(EmployeeRequestDto employee);

    EmployeeResponseDto updateEmployee(String id, EmployeeRequestDto employee);

    List<EmployeeResponseDto> findAllEmployees();

    EmployeeResponseDto findEmployeeById(String id);
}
