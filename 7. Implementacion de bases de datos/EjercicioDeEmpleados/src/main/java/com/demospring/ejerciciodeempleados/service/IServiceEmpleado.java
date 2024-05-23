package com.demospring.ejerciciodeempleados.service;

import com.demospring.ejerciciodeempleados.model.Empleado;

import java.util.List;

public interface IServiceEmpleado {
    List<Empleado> obtenerEmpleados();
    void crearEmpleado(Empleado empleado);
}
