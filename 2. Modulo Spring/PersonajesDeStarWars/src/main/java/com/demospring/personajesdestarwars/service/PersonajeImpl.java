package com.demospring.personajesdestarwars.service;

import com.demospring.personajesdestarwars.dto.PersonajeDTO;
import com.demospring.personajesdestarwars.model.Personaje;
import com.demospring.personajesdestarwars.repository.PersonajesJSON;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeImpl implements IPersonajes {
    private PersonajesJSON personajesRepository = new PersonajesJSON();

    @Override
    public List<PersonajeDTO> getPersonaje(String name) {
        List<Personaje> personajes = personajesRepository.getPersonajes().stream().filter(personaje -> personaje.getName().contains(name)).toList();
        List<PersonajeDTO> personajesDTO = new ArrayList<>();
        for (Personaje personaje : personajes) {
            personajesDTO.add(new PersonajeDTO(personaje.getName(), personaje.getHeight(), personaje.getMass(), personaje.getGender(), personaje.getHomeworld(), personaje.getSpecies()));
        }
        return personajesDTO;
    }
}
