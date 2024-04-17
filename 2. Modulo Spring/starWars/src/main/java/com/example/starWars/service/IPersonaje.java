package com.example.starWars.service;

import com.example.starWars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonaje {

    List<PersonajeDTO> personajesPorNombre(String nombre);
}
