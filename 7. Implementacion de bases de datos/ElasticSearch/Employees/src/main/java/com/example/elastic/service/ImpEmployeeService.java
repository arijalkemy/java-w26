package com.example.elastic.service;

import com.example.elastic.domain.Employee;
import com.example.elastic.repository.employeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImpEmployeeService implements EmployeeService {

    @Autowired
    private employeeRepository employeeRepository;

    @Override
    public Employee save (Employee artic) {

        return employeeRepository.save(artic);
    }

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    //va optional porque puede que devuelva como puede que no
    public Optional<Employee> findById (int id) {
        return employeeRepository.findById(id);

    }

    @Override
    public String deleteEmployee(int id) {
        employeeRepository.deleteById(id);
        return "Artículo eliminado correctamente";
    }

    @Override
    public String editEmployee (Employee art) {
        employeeRepository.save(art);
        return "Articulo modificado correctamente";
    }
}
