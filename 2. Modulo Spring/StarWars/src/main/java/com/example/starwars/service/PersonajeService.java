package com.example.starwars.service;
import com.example.starwars.entity.Personaje;
import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.repository.PersonajesJSON;

import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;
@Service
public class PersonajeService implements IPersonajeService {
    private List<Personaje> personajes;
    public PersonajeService(){
        PersonajesJSON personajesJSON = new PersonajesJSON();
        this.personajes = personajesJSON.obtenerPersonajes();
    }
    @Override
    public List<PersonajeDTO> buscarPorNombre(String nombre){
        List<Personaje> personajesEncontrados = personajes.stream().filter(x-> x.getName().contains(nombre)).toList();
        List<PersonajeDTO> personajesDTO = new ArrayList<>();
        for(Personaje personaje : personajesEncontrados){
            personajesDTO.add(new PersonajeDTO(personaje.getName(), personaje.getHeight(), personaje.getMass(), personaje.getGender(), personaje.getHomeworld(), personaje.getSpecies()));
        }
        return personajesDTO;
    }
}
