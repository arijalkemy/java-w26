package com.StarWars.StarWars.services.impl;

import com.StarWars.StarWars.dto.PersonajeDTO;
import com.StarWars.StarWars.entity.Personaje;
import com.StarWars.StarWars.services.IStarWarsRepository;
import com.StarWars.StarWars.services.IStarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StarWarsServiceImpl implements IStarWarsService {
    @Autowired
    IStarWarsRepository starWarsRepository;

    @Override
    public List<PersonajeDTO> obtenerPersonajes() {
        List<Personaje> personajeList = starWarsRepository.obtenerDatos();
        return this.mapCharacterToCharacterDTO(personajeList);
    }

    @Override
    public List<PersonajeDTO> buscarPersonajes(String nombre) {
        List<PersonajeDTO> list = this.obtenerPersonajes();
        List<PersonajeDTO> personajeList = list.stream().filter(x-> x.getName().toUpperCase().contains(nombre.toUpperCase())).toList();

        return personajeList;
    }

    private List<PersonajeDTO> mapCharacterToCharacterDTO(List<Personaje> personajes) {
        List<PersonajeDTO> personajesDTO = new ArrayList<>();

        for (Personaje personaje : personajes) {
            personajesDTO.add(
                    new PersonajeDTO(
                            personaje.getName(),
                            personaje.getGender(),
                            personaje.getHomeworld(),
                            personaje.getSpecies()
                    )
            );
        }

        return personajesDTO;
    }
}
