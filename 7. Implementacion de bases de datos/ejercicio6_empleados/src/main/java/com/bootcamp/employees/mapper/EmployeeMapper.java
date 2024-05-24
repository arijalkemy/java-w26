package com.bootcamp.employees.mapper;

import com.bootcamp.employees.dto.EmployeeDTO;
import com.bootcamp.employees.model.Employee;
import org.modelmapper.ModelMapper;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class EmployeeMapper {

    public static EmployeeDTO employeeToEmployeeDTO(Employee employee) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    public static Employee employeeDTOToEmployee(EmployeeDTO employeeDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(employeeDTO, Employee.class);
    }

    public static List<EmployeeDTO> employeesListToEmployeesDTOList(List<Employee> employees) {
        return employees.stream()
                .map(EmployeeMapper::employeeToEmployeeDTO)
                .toList();
    }

}
