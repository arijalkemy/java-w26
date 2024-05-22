package com.implementaciondb.ejercicio7_empleados_elasticsearch.mapper;

import com.implementaciondb.ejercicio7_empleados_elasticsearch.model.domain.Employee;
import com.implementaciondb.ejercicio7_empleados_elasticsearch.model.dto.EmployeeRequestDto;
import com.implementaciondb.ejercicio7_empleados_elasticsearch.model.dto.EmployeeResponseDto;

public class EmployeeMapper {

    public static Employee mapToEmployee(EmployeeRequestDto employeeRequestDto) {
        return Employee.builder()
                .nombre(employeeRequestDto.getNombre())
                .apellido(employeeRequestDto.getApellido())
                .edad(employeeRequestDto.getEdad())
                .ciudad(employeeRequestDto.getCiudad())
                .provincia(employeeRequestDto.getProvincia())
                .build();
    }

    public static EmployeeResponseDto mapToEmployeeResponseDto(Employee employee) {
        return EmployeeResponseDto.builder()
                .id(employee.getId())
                .nombre(employee.getNombre())
                .apellido(employee.getApellido())
                .edad(employee.getEdad())
                .ciudad(employee.getCiudad())
                .provincia(employee.getProvincia())
                .build();
    }

}
