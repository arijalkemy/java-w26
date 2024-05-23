package org.ggomezr.empleadoselasticsearch.application.service.impl;

import org.ggomezr.empleadoselasticsearch.application.service.interfaces.IEmployeeService;
import org.ggomezr.empleadoselasticsearch.domain.dto.EmployeeDTO;
import org.ggomezr.empleadoselasticsearch.domain.dto.ResponseDTO;
import org.ggomezr.empleadoselasticsearch.domain.exception.NotFoundException;
import org.ggomezr.empleadoselasticsearch.domain.model.Employee;
import org.ggomezr.empleadoselasticsearch.domain.repository.IEmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class EmployeeService implements IEmployeeService {

    private final IEmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(IEmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = convertToEntity(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return convertToDto(savedEmployee);
    }

    @Override
    public List<EmployeeDTO> createEmployees(List<EmployeeDTO> employeesDTO) {
        List<Employee> employees = employeesDTO.stream().map(this::convertToEntity).toList();
        List<Employee> savedEmployees = (List<Employee>) employeeRepository.saveAll(employees);
        return savedEmployees.stream().map(this::convertToDto).toList();
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        Iterable<Employee> iterable = employeeRepository.findAll();
        Stream<Employee> stream = StreamSupport.stream(iterable.spliterator(), false);
        return stream.map(this::convertToDto).toList();
    }

    @Override
    public EmployeeDTO getEmployeeById(String id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isEmpty()) throw new NotFoundException("Employee not found");

        return convertToDto(employee.get());
    }

    @Override
    public EmployeeDTO updateEmployee(String id, EmployeeDTO employeeDTO) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isEmpty()) throw new NotFoundException("Employee not found");

        Employee updatedEmployee = convertToEntity(employeeDTO);
        updatedEmployee.setId(id);

        Employee savedEmployee = employeeRepository.save(updatedEmployee);

        return convertToDto(savedEmployee);
    }

    @Override
    public ResponseDTO deleteEmployee(String id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isEmpty()) throw new NotFoundException("Employee not found");

        employeeRepository.delete(employee.get());

        return new ResponseDTO("Employee deleted successfully");
    }

    private EmployeeDTO convertToDto(Employee employee) {
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    private Employee convertToEntity(EmployeeDTO employeeDTO) {
        return modelMapper.map(employeeDTO, Employee.class);
    }
}
