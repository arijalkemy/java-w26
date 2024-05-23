package org.miprimerproyecto.elasticempleado.service;

import org.miprimerproyecto.elasticempleado.entities.Employee;

import java.util.List;

public interface IemployeeService {
    List<Employee> findAll();
    String save(Employee employee);

}
