package com.implementaciondb.ejercicio7_empleados_elasticsearch.service;

import com.implementaciondb.ejercicio7_empleados_elasticsearch.exception.NotFoundException;
import com.implementaciondb.ejercicio7_empleados_elasticsearch.mapper.EmployeeMapper;
import com.implementaciondb.ejercicio7_empleados_elasticsearch.model.domain.Employee;
import com.implementaciondb.ejercicio7_empleados_elasticsearch.model.dto.EmployeeRequestDto;
import com.implementaciondb.ejercicio7_empleados_elasticsearch.model.dto.EmployeeResponseDto;
import com.implementaciondb.ejercicio7_empleados_elasticsearch.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public EmployeeResponseDto saveEmployee(EmployeeRequestDto employee) {
        Employee savedEmployed = employeeRepository.save(EmployeeMapper.mapToEmployee(employee));
        return EmployeeMapper.mapToEmployeeResponseDto(savedEmployed);
    }

    @Override
    public List<EmployeeResponseDto> findAllEmployees() {
        Iterable<Employee> iterable = employeeRepository.findAll();
        List<Employee> employees = StreamSupport.stream(iterable.spliterator(), false).toList();
        return employees.stream().map(EmployeeMapper::mapToEmployeeResponseDto).toList();
    }

    @Override
    public EmployeeResponseDto findEmployeeById(String id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "No existe un empleado con el id: " + id)
        );
        return EmployeeMapper.mapToEmployeeResponseDto(employee);
    }

    @Override
    public EmployeeResponseDto updateEmployee(String id, EmployeeRequestDto employee) {
        findEmployeeById(id);
        Employee employee1 = EmployeeMapper.mapToEmployee(employee);
        employee1.setId(id);
        Employee updatedEmployed = employeeRepository.save(employee1);
        return EmployeeMapper.mapToEmployeeResponseDto(updatedEmployed);
    }

}
