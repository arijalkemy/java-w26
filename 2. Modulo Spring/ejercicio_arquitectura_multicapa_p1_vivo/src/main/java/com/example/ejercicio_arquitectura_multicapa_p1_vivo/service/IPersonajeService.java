package com.example.ejercicio_arquitectura_multicapa_p1_vivo.service;

import com.example.ejercicio_arquitectura_multicapa_p1_vivo.dto.PersonajeDto;

import java.util.List;

public interface IPersonajeService {
    public List<PersonajeDto> buscarPersonajes(String name);
}
