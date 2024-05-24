package org.example.empleados.services;

import org.example.empleados.models.DTO.EmployeeRequestDTO;
import org.example.empleados.models.DTO.EmployeeResponseDTO;
import java.util.List;

public interface IEmployeeService {
    List<EmployeeResponseDTO> findAll();
    EmployeeResponseDTO findById(String id);
    EmployeeResponseDTO createNew(EmployeeRequestDTO employee);
    EmployeeResponseDTO updateEmployeeById(String id, EmployeeRequestDTO empleado);
    String deleteEmployee(String id);
    List<EmployeeResponseDTO> findEmployeeByDepto(String depto);

}
