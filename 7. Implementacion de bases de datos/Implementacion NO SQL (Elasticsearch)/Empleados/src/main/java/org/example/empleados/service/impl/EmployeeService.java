package org.example.empleados.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.empleados.dto.EmployeeRequestDTO;
import org.example.empleados.dto.EmployeeResponseDTO;
import org.example.empleados.model.Employee;
import org.example.empleados.repository.IEmployeeRepository;
import org.example.empleados.service.IEmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService {

    private final IEmployeeRepository employeeRepository;
    private final ObjectMapper objectMapper;

    @Override
    public String createEmployee(EmployeeRequestDTO employeeRequestDTO) {
        Employee newEmployee = objectMapper.convertValue(employeeRequestDTO, Employee.class);
        employeeRepository.save(newEmployee);
        return newEmployee.getId();
    }

    @Override
    public EmployeeResponseDTO updateEmployee(String id, EmployeeRequestDTO employeeRequestDTO) {
        Optional<Employee> result = employeeRepository.findById(id);
        if (result.isPresent()){
            Employee actualEmployee = result.get();
            actualEmployee.setFirstname(employeeRequestDTO.getFirstname());
            actualEmployee.setLastname(employeeRequestDTO.getLastname());
            actualEmployee.setCity(employeeRequestDTO.getCity());
            actualEmployee.setState(employeeRequestDTO.getState());
            employeeRepository.save(actualEmployee);
            return objectMapper.convertValue(actualEmployee, EmployeeResponseDTO.class);
        }
        return null;
    }

    @Override
    public List<EmployeeResponseDTO> getAllEmployees() {
        List<EmployeeResponseDTO> employeeResponseDTOList = new ArrayList<>();
        employeeRepository.findAll()
                .forEach(
                        employee ->
                                employeeResponseDTOList.add(objectMapper
                                        .convertValue(employee, EmployeeResponseDTO.class)));
        return employeeResponseDTOList;
    }
}
