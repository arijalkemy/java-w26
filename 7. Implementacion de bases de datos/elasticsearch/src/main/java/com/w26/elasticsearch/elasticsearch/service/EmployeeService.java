package com.w26.elasticsearch.elasticsearch.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.w26.elasticsearch.elasticsearch.dto.EmployeeDTO;
import com.w26.elasticsearch.elasticsearch.entity.Employee;
import com.w26.elasticsearch.elasticsearch.repository.EmployeeRepository;
import com.w26.elasticsearch.elasticsearch.service.interfaces.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {
    
    @Autowired
    EmployeeRepository employeeRepository;

    private final ObjectMapper objectMapper;
    
    public EmployeeService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public List<Employee> getAllEmployee() {
        Iterable<Employee> employIterable = employeeRepository.findAll();
        List<Employee> employees = StreamSupport.stream(employIterable.spliterator(), false).toList();
        
        return employees;
    }

    @Override
    public String createEmployee(EmployeeDTO employeeDTO) {
        Employee employeeToSave = objectMapper.convertValue(employeeDTO, Employee.class);
        Employee employeeSave = employeeRepository.save(employeeToSave);
        return employeeSave.getId();
    }

    @Override
    public Boolean updateEmployee(String id, EmployeeDTO employeeDTO) {
        Optional<Employee> optional = employeeRepository.findById(id);
        
        if (optional.isEmpty()) {
            return false;
        }

        Employee employeeSaved = optional.get();
        Employee employeDataToUpdate = objectMapper.convertValue(employeeDTO, Employee.class);
        
        employeDataToUpdate.setId(employeeSaved.getId());
        employeeRepository.save(employeDataToUpdate);
        return true;        
    }
    
}
