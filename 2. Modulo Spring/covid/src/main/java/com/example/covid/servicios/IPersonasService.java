package com.example.covid.servicios;

import com.example.covid.modelo.Persona;

import java.util.List;

public interface IPersonasService {
    public List<Persona> personasDeRiesgo();
}
