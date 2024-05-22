package org.example.elastic.service.impl;

import org.example.elastic.entity.Employee;
import org.example.elastic.dto.employee.EmployeeRequestDto;
import org.example.elastic.dto.employee.EmployeeResponseDto;
import org.example.elastic.repository.IEmployeeRepository;
import org.example.elastic.service.IEmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    private final IEmployeeRepository employeeRepository;

    public EmployeeServiceImpl(@Autowired IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponseDto getEmployeeById(String id) {
        ModelMapper modelMapper = new ModelMapper();
        return employeeRepository
                .findById(id).map(employee -> modelMapper.map(employee, EmployeeResponseDto.class))
                .orElseThrow();
    }

    @Override
    public EmployeeResponseDto createEmployee(EmployeeRequestDto employeeRequestDto) {
        ModelMapper modelMapper = new ModelMapper();
        Employee saved = employeeRepository.save(modelMapper.map(employeeRequestDto, Employee.class));
        return modelMapper.map(saved, EmployeeResponseDto.class);
    }

    @Override
    public EmployeeResponseDto updateEmployee(String id, EmployeeRequestDto employeeDto) {
        ModelMapper modelMapper = new ModelMapper();
        Employee saved = modelMapper.map(employeeDto, Employee.class);
        saved.setId(id);
        return modelMapper.map(employeeRepository.save(saved), EmployeeResponseDto.class);
    }
}
