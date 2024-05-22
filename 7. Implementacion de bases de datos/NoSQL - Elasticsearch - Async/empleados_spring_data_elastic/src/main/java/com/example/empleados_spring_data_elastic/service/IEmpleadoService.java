package com.example.empleados_spring_data_elastic.service;

import com.example.empleados_spring_data_elastic.domain.Empleado;

import java.util.List;

public interface IEmpleadoService {
    public Empleado save(Empleado empleado);
    public List<Empleado> findAll();
}
