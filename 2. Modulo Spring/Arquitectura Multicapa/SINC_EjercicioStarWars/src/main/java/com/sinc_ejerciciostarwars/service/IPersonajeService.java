package com.sinc_ejerciciostarwars.service;

import com.sinc_ejerciciostarwars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDTO> buscarPersonajePorNombre(String nombre);

    List<PersonajeDTO> buscarTodos();
}
