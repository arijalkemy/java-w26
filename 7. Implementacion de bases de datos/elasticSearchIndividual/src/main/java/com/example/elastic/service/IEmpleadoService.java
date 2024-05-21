package com.example.elastic.service;

import com.example.elastic.model.Empleado;

public interface IEmpleadoService {
     int save (Empleado empleado);

     Empleado editEmpleado (Empleado empleado);
}
