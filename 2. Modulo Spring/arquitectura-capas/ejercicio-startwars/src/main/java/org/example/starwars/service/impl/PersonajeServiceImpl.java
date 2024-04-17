package org.example.starwars.service.impl;

import org.example.starwars.dto.PersonajeDTO;
import org.example.starwars.model.Personaje;
import org.example.starwars.repository.PersonajeRepository;
import org.example.starwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServiceImpl implements IPersonajeService {

    @Autowired
    private PersonajeRepository personajeRepository;

    @Override
    public List<PersonajeDTO> buscarTodos() {
        return personajeRepository.buscarTodos().stream().map(PersonajeServiceImpl::convertirADTO).toList();
    }

    @Override
    public List<PersonajeDTO> buscarPorNombre(String nombre) {

        return personajeRepository.buscarPorNombre(nombre).stream()
            .map(PersonajeServiceImpl::convertirADTO)
            .toList();
    }


    private static PersonajeDTO convertirADTO(Personaje personaje) {
        return new PersonajeDTO(
            personaje.getName(),
            personaje.getHeight(),
            personaje.getMass(),
            personaje.getGender(),
            personaje.getHomeworld(),
            personaje.getSpecies()
        );
    }
}
