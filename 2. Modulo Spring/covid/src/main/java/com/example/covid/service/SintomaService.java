package com.example.covid.service;

import com.example.covid.dto.Riesgo;
import com.example.covid.entity.Sintoma;

import java.util.List;

public interface SintomaService {

    public List<Sintoma> todosLosSintomas();

    public Sintoma existeSintoma(String nombre);

    public List<Riesgo> personasRiesgo();
}
