package org.example.starswars.service;

import org.example.starswars.DTO.PersonajeDTO;
import org.example.starswars.Model.Personaje;
import org.example.starswars.repository.StarWarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StarWarsService {
    @Autowired
    StarWarsRepository starWarsRepository;
    public List<PersonajeDTO> allCharacterDTO(){
        List<Personaje> personajes = starWarsRepository.allCharacters();
        List<PersonajeDTO> dtoList = new ArrayList<>();
        for (Personaje personaje : personajes){
             dtoList.add(new PersonajeDTO(personaje.getName(), personaje.getHeight(), personaje.getMass(), personaje.getGender(), personaje.getHomeworld(), personaje.getSpecies()));
        }
        return  dtoList;
    }

    public List<PersonajeDTO> buscarPersonajePorNombre(String nombre){
        List<Personaje> personajes = starWarsRepository.buscarPersonajePorNombre(nombre);

        return personajes
                .stream()
                .map(
                        p -> new PersonajeDTO(
                                p.getName(),p.getHeight(),p.getMass(),p.getGender(),p.getHomeworld(),p.getSpecies()
                        )
                )
                .toList();

    }
}
