package com.bootcampjava.covid19.service;

import com.bootcampjava.covid19.model.DTOs.SintomaDTO;
import com.bootcampjava.covid19.model.Sintoma;

import java.util.List;

public interface ISintomasService {
    public List<Sintoma> obtenerTodosSintomas();
    public SintomaDTO obtenerSintomaPorNombre(String nombre);
}
