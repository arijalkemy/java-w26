package com.demospring.personajesdestarwars.service;

import com.demospring.personajesdestarwars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajes {
    List<PersonajeDTO> getPersonaje(String name);
}
