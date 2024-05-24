package com.bootcamp.employees.service.impl;

import java.util.List;

import com.bootcamp.employees.dto.EmployeeDTO;
import com.bootcamp.employees.dto.ResponseDTO;
import com.bootcamp.employees.exception.NotFoundException;
import com.bootcamp.employees.mapper.EmployeeMapper;
import com.bootcamp.employees.model.Employee;
import com.bootcamp.employees.service.IEmployeeService;
import org.springframework.stereotype.Service;

import com.bootcamp.employees.repository.IEmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepository employeeRepository;
    private final String NAME_ENTITY = "employee";

    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDTO> getAlls() {
        return EmployeeMapper.employeesListToEmployeesDTOList(
                employeeRepository.findAll());
    }

    public EmployeeDTO getEmployeeById(String id) {
        return EmployeeMapper.employeeToEmployeeDTO(
                employeeRepository.findById(id).orElseThrow(() -> new NotFoundException(NAME_ENTITY)));
    }

    @Override
    public ResponseDTO create(EmployeeDTO employeeDTO) {
        Employee employeee = employeeRepository.
                save(EmployeeMapper.employeeDTOToEmployee(employeeDTO));
        return new ResponseDTO("Employee created successfully with id: " + employeee.getId() + " success.");
    }

    @Override
    public ResponseDTO update(String id, EmployeeDTO employeeDTO) {
        validate(employeeDTO.getId());
        Employee employee = employeeRepository.save(EmployeeMapper.employeeDTOToEmployee(employeeDTO));
        return new ResponseDTO("Employee updated successfully with id: " + employee.getId() + " success.");
    }

    @Override
    public void delete(String id) {
        validate(id);
        employeeRepository.deleteById(id);
    }

    private void validate(String id) {
        if (!employeeRepository.existsById(id))
            throw new NotFoundException(NAME_ENTITY);

    }

}
