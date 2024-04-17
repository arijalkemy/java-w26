package com.example.covid.servicios;

import com.example.covid.modelo.Sintoma;

import java.util.List;
import java.util.Optional;

public interface ISintomasService {

    public List<Sintoma> obtenerTodos();
    public Optional<Sintoma> obtenerSintomaDadoElNombre(String nombre);
}
