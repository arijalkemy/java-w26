package com.example.personajesstarwars.services;

import com.example.personajesstarwars.dto.PersonajeDTO;
import com.example.personajesstarwars.model.Personaje;
import com.example.personajesstarwars.repository.PersonajeRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IPersonajeService{

    private List<Personaje> personajes;

    public PersonajeService(){
        PersonajeRepositoryImpl personajeRepository = new PersonajeRepositoryImpl();
        this.personajes = personajeRepository.obtenerNombres();
    }

    @Override
    public List<PersonajeDTO> buscarPorNombre(String nombre) {
        List<Personaje> personajesEncontrados = personajes.stream()
                                                .filter(p->p.getName().equals(nombre))
                                                .toList();
        List<PersonajeDTO> personajesDTO = new ArrayList<>();
        for(Personaje personaje : personajesEncontrados){
            personajesDTO.add(new PersonajeDTO(personaje.getName(), personaje.getHeight(),personaje.getMass(),
                    personaje.getGender(),personaje.getHomeWorld(),personaje.getSpecies()));
        }
        return personajesDTO;
    }
}
