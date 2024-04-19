package com.example.starwars.service;

import com.example.starwars.dto.PersonajeDto;
import com.example.starwars.model.Personaje;

import java.util.List;

public interface IPersonajeService {

    public PersonajeDto obtenerPersonaje( String nombre );

    public void crearPersonajes( List<Personaje> personajes );
}
