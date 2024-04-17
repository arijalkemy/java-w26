package com.bootcamp.starwars.Service;

import com.bootcamp.starwars.DTO.PersonajeDTO;
import com.bootcamp.starwars.Model.Personaje;
import com.bootcamp.starwars.Repository.PersonajesJSON;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PersonajeService implements IPersonajeService {

    private List<Personaje> personajes;

    public PersonajeService() {
        PersonajesJSON personajesJSON = new PersonajesJSON();
        this.personajes = personajesJSON.obtenerPersonajes();
    }

    @Override
    public List<PersonajeDTO> buscarPorNombre(String nombre) {
        List<Personaje> personajesEncontrados = personajes.stream().filter(x -> x.getName().contains(nombre)).toList();
        List<PersonajeDTO> personajesDTO = new ArrayList<>();
        for (Personaje personaje :
                personajesEncontrados) {
            personajesDTO.add(new PersonajeDTO(personaje.getName(), personaje.getHeight(), personaje.getMass(),
                    personaje.getGender(), personaje.getHomeWorld(), personaje.getSpecies()));
        }
        return personajesDTO;

    }
}
