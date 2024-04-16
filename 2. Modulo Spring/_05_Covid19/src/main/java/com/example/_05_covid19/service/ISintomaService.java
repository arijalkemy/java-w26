package com.example._05_covid19.service;

import com.example._05_covid19.model.Sintoma;

import java.util.List;

public interface ISintomaService {
    public List<Sintoma> obtenerSintomas();
    public Sintoma obtenerSintoma(String nombre);
}
