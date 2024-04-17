package com.example.personajesStarWars.service;

import com.example.personajesStarWars.dto.PersonaDTO;
import com.example.personajesStarWars.model.Persona;
import com.example.personajesStarWars.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements IPersonaService{


    @Autowired
    private IPersonaRepository iPersonaRepository;


    @Override
    public List<PersonaDTO> buscarPersonajes(String nombre) {
        List<Persona> personas = iPersonaRepository.obtenerPersonas();
        List<PersonaDTO> personasFiltradas = personas.stream().filter(persona -> persona.getName().toLowerCase().contains(nombre.toLowerCase())).map(this::convertirADTO).collect(Collectors.toList());
        return personasFiltradas;
    }

    public PersonaDTO convertirADTO (Persona persona){
        PersonaDTO personaDTO = new PersonaDTO();

        personaDTO.setName(persona.getName());
        personaDTO.setGender(persona.getGender());
        personaDTO.setHeight(persona.getHeight());
        personaDTO.setHomeworld(persona.getHomeworld());
        personaDTO.setMass(persona.getMass());
        personaDTO.setSpecies(persona.getSpecies());

        return personaDTO;

    }
}
