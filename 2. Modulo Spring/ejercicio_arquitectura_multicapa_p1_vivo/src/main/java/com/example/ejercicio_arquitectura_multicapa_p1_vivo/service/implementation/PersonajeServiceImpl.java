package com.example.ejercicio_arquitectura_multicapa_p1_vivo.service.implementation;

import com.example.ejercicio_arquitectura_multicapa_p1_vivo.dto.PersonajeDto;
import com.example.ejercicio_arquitectura_multicapa_p1_vivo.entity.Personaje;
import com.example.ejercicio_arquitectura_multicapa_p1_vivo.repository.IPersonajeRepository;
import com.example.ejercicio_arquitectura_multicapa_p1_vivo.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeServiceImpl implements IPersonajeService {
    @Autowired
    private IPersonajeRepository personajeRepository;
    public List<PersonajeDto> buscarPersonajes(String name) {
        List<PersonajeDto> personajesDto = new ArrayList<>();

        List<Personaje> personajes = personajeRepository.buscarPersonajesPorNombre(name);
        for(Personaje personaje : personajes) {
            personajesDto.add(new PersonajeDto(
                    personaje.getName(),
                    personaje.getHeight(),
                    personaje.getMass(),
                    personaje.getGender(),
                    personaje.getHomeworld(),
                    personaje.getSpecies()
            ));
        }

        return personajesDto;
    }
}
