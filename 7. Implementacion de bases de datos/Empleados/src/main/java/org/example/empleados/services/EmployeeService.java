package org.example.empleados.services;

import org.example.empleados.exceptions.NotFoundException;
import org.example.empleados.models.DTO.EmployeeRequestDTO;
import org.example.empleados.models.DTO.EmployeeResponseDTO;
import org.example.empleados.models.Employee;
import org.example.empleados.repository.IEmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    private final String notFoundMessage = "No employee with the provided id was found";

    private final ModelMapper mapper;
    private IEmployeeRepository employeeRepository;

    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        mapper=new ModelMapper();
    }

    @Override
    public List<EmployeeResponseDTO> findAll() {
        return employeeRepository.findAll()
                .stream()
                .map(this::convertModelToDTO)
                .toList();
    }

    @Override
    public EmployeeResponseDTO findById(String id) {
        return convertModelToDTO(this.findByID(id));
    }

    @Override
    public EmployeeResponseDTO createNew(EmployeeRequestDTO employee) {
        Employee newEmployee = convertDTOtoModel(employee);
        newEmployee =  employeeRepository.save(newEmployee);
        return convertModelToDTO(newEmployee);
    }

    @Override
    public EmployeeResponseDTO updateEmployeeById(String id, EmployeeRequestDTO employee) {
        this.findByID(id);
        Employee updatedEmployee = this.convertDTOtoModel(employee);
        updatedEmployee.setId(id);
        updatedEmployee = employeeRepository.save(updatedEmployee);
        return convertModelToDTO(updatedEmployee);
    }

    @Override
    public String deleteEmployee(String id) {
        this.findByID(id);
        employeeRepository.deleteById(id);
        return "Employee deleted, successfully";
    }

    @Override
    public List<EmployeeResponseDTO> findEmployeeByDepto(String depto) {
        return employeeRepository.findAllByDepartmentContainingIgnoreCase(depto, Pageable.unpaged())
                .stream()
                .map(this::convertModelToDTO)
                .toList();
    }

    private Employee findByID(String id){
        return employeeRepository.findById(id).orElseThrow(()->
                new NotFoundException(this.notFoundMessage));
    }

    private Employee convertDTOtoModel(EmployeeRequestDTO employee){
        return mapper.map(employee, Employee.class);
    }

    private EmployeeResponseDTO convertModelToDTO(Employee employee){
        return mapper.map(employee, EmployeeResponseDTO.class);
    }


}
