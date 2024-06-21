package org.bootcamp.implementacionnosql.service;

import org.bootcamp.implementacionnosql.dto.EmployeeDTO;
import org.bootcamp.implementacionnosql.dto.ResponseEmployeeDTO;
import org.bootcamp.implementacionnosql.model.Employee;
import org.bootcamp.implementacionnosql.repository.IEmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    IEmployeeRepository employeeRepository;

    private ModelMapper modelMapper;

    public EmployeeServiceImpl() {
        modelMapper = new ModelMapper();
    }

    @Override
    public ResponseEmployeeDTO createEmployee(EmployeeDTO employee) {
        Employee employeeEntity = modelMapper.map(employee, Employee.class);
        employeeEntity = employeeRepository.save(employeeEntity);

        return modelMapper.map(employeeEntity, ResponseEmployeeDTO.class);
    }

    @Override
    public ResponseEmployeeDTO updateEmployee(String id, EmployeeDTO employee) {
        Employee employeeEntity = modelMapper.map(employee, Employee.class);
        employeeEntity.setId(id);

        employeeEntity = employeeRepository.save(employeeEntity);

        return modelMapper.map(employeeEntity, ResponseEmployeeDTO.class);
    }
}
