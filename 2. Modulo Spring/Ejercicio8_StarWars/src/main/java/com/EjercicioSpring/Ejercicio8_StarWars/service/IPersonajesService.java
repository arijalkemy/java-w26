package com.EjercicioSpring.Ejercicio8_StarWars.service;

import com.EjercicioSpring.Ejercicio8_StarWars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajesService {

    public List<PersonajeDTO> getPersonajes(String partName);

}
