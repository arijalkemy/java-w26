package org.bootcamp.implementacionnosql.service;

import org.bootcamp.implementacionnosql.dto.EmployeeDTO;
import org.bootcamp.implementacionnosql.dto.ResponseEmployeeDTO;

public interface IEmployeeService {
    ResponseEmployeeDTO createEmployee(EmployeeDTO employee);
    ResponseEmployeeDTO updateEmployee(String id, EmployeeDTO employee);
}
