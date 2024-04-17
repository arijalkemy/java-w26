package com.bootcamp.starwars.Service;

import com.bootcamp.starwars.DTO.PersonajeDTO;
import com.bootcamp.starwars.Model.Personaje;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IPersonajeService {

    public List<PersonajeDTO> buscarPorNombre(String nombre);
}
