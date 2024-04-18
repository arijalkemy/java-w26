package com.ejercicios.fechanacimiento.service;

import org.springframework.stereotype.Service;

public interface EdadService {

    Integer calcularEdad(Integer anio, Integer mes, Integer dia);

}
