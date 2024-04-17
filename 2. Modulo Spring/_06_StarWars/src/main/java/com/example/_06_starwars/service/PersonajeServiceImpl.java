package com.example._06_starwars.service;

import com.example._06_starwars.dto.PersonajeDTO;
import com.example._06_starwars.entity.Personaje;
import com.example._06_starwars.repository.IPersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeServiceImpl implements IPersonajeService{
    @Autowired
    IPersonajeRepository iPersonajeRepository;


    @Override
    public List<PersonajeDTO> obtenerPersonajes() {
        List<PersonajeDTO> personajesDTO = transformarADto(iPersonajeRepository.obtenerPersonajes());

        return personajesDTO;
    }

    @Override
    public List<PersonajeDTO> obtenerPersonajesPorNombre(String nombre) {
        List<PersonajeDTO> personajesDTO = transformarADto(iPersonajeRepository.obtenerPersonajes());

        personajesDTO = personajesDTO.stream()
                .filter(p->p.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .toList();

        return personajesDTO;
    }

    private List<PersonajeDTO> transformarADto(List<Personaje> personajes){
        List<PersonajeDTO> personajeDTOS = new ArrayList<>();

        for (Personaje personaje : personajes){
            PersonajeDTO personajeDTO = new PersonajeDTO();
            personajeDTO.setNombre(personaje.getName());
            personajeDTO.setEspecie(personaje.getSpecies());
            personajeDTO.setMundoNatal(personaje.getHomeworld());
            personajeDTO.setGenero(personaje.getGender());
            personajeDTO.setPeso(personaje.getMass());
            personajeDTO.setAltura(personaje.getHeight());

            personajeDTOS.add(personajeDTO);
        }
        return personajeDTOS;
    }
}
