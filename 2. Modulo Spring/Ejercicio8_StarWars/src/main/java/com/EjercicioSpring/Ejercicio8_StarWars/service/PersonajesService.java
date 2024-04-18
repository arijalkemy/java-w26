package com.EjercicioSpring.Ejercicio8_StarWars.service;

import com.EjercicioSpring.Ejercicio8_StarWars.dto.PersonajeDTO;
import com.EjercicioSpring.Ejercicio8_StarWars.entity.Personaje;
import com.EjercicioSpring.Ejercicio8_StarWars.repository.PersonajeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajesService implements IPersonajesService{


    @Override
    public List<PersonajeDTO> getPersonajes(String partName) {
        List<Personaje> personajes = new PersonajeRepository().getAll().stream().filter(x -> x.getName().toLowerCase().contains(partName.toLowerCase())).toList();
        List<PersonajeDTO> personajesDTO = new ArrayList<>();
        for (Personaje personaje : personajes) {
            PersonajeDTO personajeDTO = new PersonajeDTO(
                    personaje.getName(),
                    personaje.getHeight(),
                    personaje.getMass(),
                    personaje.getGender(),
                    personaje.getHomeworld(),
                    personaje.getSpecies()
            );
            personajesDTO.add(personajeDTO);
        }
        return personajesDTO;
    }
}
