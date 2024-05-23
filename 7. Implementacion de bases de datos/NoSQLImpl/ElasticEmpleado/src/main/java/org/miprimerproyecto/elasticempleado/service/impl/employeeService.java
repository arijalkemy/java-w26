package org.miprimerproyecto.elasticempleado.service.impl;

import org.miprimerproyecto.elasticempleado.entities.Employee;
import org.miprimerproyecto.elasticempleado.repository.employeeRepository;
import org.miprimerproyecto.elasticempleado.service.IemployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class employeeService implements IemployeeService {

    @Autowired
    private employeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public String save(Employee employee) {
        try {
            employeeRepository.save(employee);
            return "Empleado guardado correctamente";
        } catch (Exception e) {
            return "Error al guardar el empleado";
        }
    }
}
