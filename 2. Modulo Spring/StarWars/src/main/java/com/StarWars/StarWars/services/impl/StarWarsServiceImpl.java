package com.StarWars.StarWars.services.impl;

import com.StarWars.StarWars.dto.PersonajeDTO;
import com.StarWars.StarWars.entity.Personaje;
import com.StarWars.StarWars.repository.IStarWarsRepository;
import com.StarWars.StarWars.services.IStarWarsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StarWarsServiceImpl implements IStarWarsService {
    @Autowired
    IStarWarsRepository _starWarsRepository;


    @Override
    public List<Personaje> obtenerPersonajes() {
        List<Personaje> personajeList = _starWarsRepository.obtenerPesonajes();
        List<PersonajeDTO> personajeDTOList = new ArrayList<>();


        for (Personaje item : personajeList) {
            personajeDTOList.add(new PersonajeDTO(item.getName(), item.getGender(), item.getHomeworld(), item.getSpecies()));
        }
        return personajeList;


    }

    @Override
    public List<Personaje> buscarPersonajes(String nombre) {
        List<Personaje> list = _starWarsRepository.obtenerPesonajes();
        List<Personaje> personajeList = list.stream().filter(x-> x.getName().toUpperCase().contains(nombre.toUpperCase())).toList();
        return personajeList;
    }
}
