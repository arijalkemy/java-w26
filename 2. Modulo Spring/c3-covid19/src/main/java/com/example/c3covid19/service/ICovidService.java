package com.example.c3covid19.service;

import com.example.c3covid19.entity.Sintoma;

import java.util.List;

public interface ICovidService {

    List<Sintoma> mostrarSintomas();
    Sintoma buscarSintoma(String nombre);

}
