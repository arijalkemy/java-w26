package org.ggomezr.empleadoselasticsearch.application.service.interfaces;

import org.ggomezr.empleadoselasticsearch.domain.dto.EmployeeDTO;
import org.ggomezr.empleadoselasticsearch.domain.dto.ResponseDTO;
import org.ggomezr.empleadoselasticsearch.domain.model.Employee;

import java.util.List;

public interface IEmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> createEmployees(List<EmployeeDTO> employeesDTO);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(String id);
    EmployeeDTO updateEmployee(String id, EmployeeDTO employeeDTO);
    ResponseDTO deleteEmployee(String id);
}
