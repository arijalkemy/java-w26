package org.responseentity.elasticspring.service;

import org.responseentity.elasticspring.dto.request.EmployeeRequestDto;
import org.responseentity.elasticspring.dto.response.EmployeeResponseDto;

public interface IEmployeeService {
    EmployeeResponseDto addEmployee(EmployeeRequestDto employeeRequestDto);
    EmployeeResponseDto editEmployee(String id, EmployeeRequestDto employeeRequestDto);

}
