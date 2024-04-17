package com.example.deportistas.service;

import com.example.deportistas.dto.DeporteDTO;
import com.example.deportistas.dto.PersonaDTO;
import com.example.deportistas.model.Deporte;
import com.example.deportistas.model.Persona;
import com.example.deportistas.repository.DeportesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeportesService implements IDeportesService {

    @Autowired
    public DeportesRepository deportesRepository;

    @Override
    public List<Deporte> findSports() {
        return deportesRepository.findAllDeportes();
    }

    @Override
    public DeporteDTO findSport(String nombre) {
        DeporteDTO deporteDTO = new DeporteDTO();
        deporteDTO.setNivel(deportesRepository.findById(nombre).getNivel());
        return deporteDTO;
    }

    @Override
    public List<PersonaDTO> findSportsByPersons() {
        List<Persona> personasDeportivas = deportesRepository.findSportsPersons();
        return personasDeportivas.stream().map(this::convertPersonaToDTO).collect(Collectors.toList());
    }

    private PersonaDTO convertPersonaToDTO(Persona persona) {
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setNombre(persona.getNombre());
        personaDTO.setApellido(persona.getApellido());
        personaDTO.setDeporteNombre(persona.getDeporte().getNombre());
        return personaDTO;
    }
}
