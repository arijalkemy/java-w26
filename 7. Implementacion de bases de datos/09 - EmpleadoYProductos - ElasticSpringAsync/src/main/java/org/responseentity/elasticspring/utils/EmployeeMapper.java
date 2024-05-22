package org.responseentity.elasticspring.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.responseentity.elasticspring.domain.Employee;
import org.responseentity.elasticspring.dto.request.EmployeeRequestDto;
import org.responseentity.elasticspring.dto.response.EmployeeResponseDto;

public class EmployeeMapper {

    public static Employee mapToEmployee(EmployeeRequestDto employeeRequestDto){
        return new ObjectMapper().convertValue(employeeRequestDto, Employee.class);
    }
    public static EmployeeResponseDto mapToResponseDto(Employee employee){
        return new ObjectMapper().convertValue(employee, EmployeeResponseDto.class);
    }

}
