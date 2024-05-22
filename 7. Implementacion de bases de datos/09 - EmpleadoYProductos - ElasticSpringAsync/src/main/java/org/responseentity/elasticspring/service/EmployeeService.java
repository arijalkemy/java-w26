package org.responseentity.elasticspring.service;

import org.responseentity.elasticspring.domain.Employee;
import org.responseentity.elasticspring.dto.request.EmployeeRequestDto;
import org.responseentity.elasticspring.dto.response.EmployeeResponseDto;
import org.responseentity.elasticspring.repository.IEmployeeRepository;
import org.responseentity.elasticspring.utils.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    IEmployeeRepository iEmployeeRepository;

    @Override
    public EmployeeResponseDto addEmployee(EmployeeRequestDto employeeRequestDto) {
        Employee employee = iEmployeeRepository.save(EmployeeMapper.mapToEmployee(employeeRequestDto));

        return EmployeeMapper.mapToResponseDto(employee);
    }

    @Override
    public EmployeeResponseDto editEmployee(String id, EmployeeRequestDto employeeRequestDto) {
        Employee employee = iEmployeeRepository.findById(id).orElseThrow();

        employee.setNombre(employeeRequestDto.getNombre());
        employee.setApellido(employeeRequestDto.getApellido());
        employee.setCiudad(employeeRequestDto.getCiudad());
        employee.setProvincia(employeeRequestDto.getProvincia());
        employee.setEdad(employeeRequestDto.getEdad());

        iEmployeeRepository.save(employee);

        return EmployeeMapper.mapToResponseDto(employee);
    }
}
