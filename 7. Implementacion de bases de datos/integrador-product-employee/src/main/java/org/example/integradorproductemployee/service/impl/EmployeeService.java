package org.example.integradorproductemployee.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.integradorproductemployee.entity.Employee;
import org.example.integradorproductemployee.entity.dto.EmployeeDTO;
import org.example.integradorproductemployee.entity.dto.EmployeeUtilDTO;
import org.example.integradorproductemployee.repository.IEmployeeRepository;
import org.example.integradorproductemployee.service.IEmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService {

    private final IEmployeeRepository employeeRepository;
    private final ObjectMapper objectMapper;

    private EmployeeUtilDTO mapToUtilDTO(Employee employee){
        return objectMapper.convertValue(employee, EmployeeUtilDTO.class);
    }

    private EmployeeDTO mapToDTO(Employee employee){
        return objectMapper.convertValue(employee, EmployeeDTO.class);
    }

    private Employee mapToEntity(EmployeeDTO employeeDTO){
        return objectMapper.convertValue(employeeDTO, Employee.class);
    }

    private Employee mapToEntity(EmployeeUtilDTO employeeDTO){
        return objectMapper.convertValue(employeeDTO, Employee.class);
    }

    @Override
    public List<EmployeeUtilDTO> getAllEmployees() {
        Iterable<Employee> employeeList = employeeRepository.findAll();
        List<Employee> employees = StreamSupport.stream(employeeList.spliterator(), false).toList();
        return employees.stream().map(this::mapToUtilDTO).toList();
    }

    @Override
    public EmployeeDTO getEmployeeById(String id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.map(this::mapToDTO).orElse(null);
    }

    @Override
    public void createEmployee(EmployeeDTO employeeDTO) {
        employeeRepository.save(mapToEntity(employeeDTO));
    }

    @Override
    public void updateEmployee(EmployeeUtilDTO employeeUtilDTO) {
        employeeRepository.save(mapToEntity(employeeUtilDTO));
    }
}
