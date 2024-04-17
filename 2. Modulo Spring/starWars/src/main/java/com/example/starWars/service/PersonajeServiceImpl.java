package com.example.starWars.service;

import com.example.starWars.dto.PersonajeDTO;
import com.example.starWars.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServiceImpl implements IPersonaje{


    @Autowired
    PersonajeRepository personajeRepository;

    @Override
    public List<PersonajeDTO> personajesPorNombre(String nombre) {
        return personajeRepository.findAll()
                .stream().
                filter(character -> character.getName().toLowerCase().contains(nombre.toLowerCase()))
                .toList();
    }
}
