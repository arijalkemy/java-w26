package com.demospring.personajesdestarwars.service;

import com.demospring.personajesdestarwars.dto.PersonajeDTO;
import com.demospring.personajesdestarwars.model.Personaje;
import com.demospring.personajesdestarwars.repository.PersonajesJSON;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeImpl implements IPersonajes {
    private PersonajesJSON personajesRepository = new PersonajesJSON();

    @Override
    public List<PersonajeDTO> getPersonaje(String name) {
        return personajesRepository.getPersonajes().stream()
                .filter(personaje -> personaje.getName().contains(name))
                .map(personaje -> new PersonajeDTO(personaje.getName(), personaje.getHeight(), personaje.getMass(), personaje.getGender(), personaje.getHomeworld(), personaje.getSpecies()))
                .toList();
    }
}
