package org.ggomezr.deportistas.application.service.impl;

import org.ggomezr.deportistas.application.service.interfaces.IPersonaService;
import org.ggomezr.deportistas.domain.dto.PersonaDTO;
import org.ggomezr.deportistas.domain.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private DeporteService deporteService;
    List<Persona> personas;

    public PersonaService(DeporteService deporteService) {
        this.deporteService = deporteService;
        this.personas = Arrays.asList(
                new Persona("Geraldine", "Gomez", 20, deporteService.deportes.get(0)),
                new Persona("Sandra", "Romero", 28, deporteService.deportes.get(1)),
                new Persona("Jennifer", "Gomez", 23, deporteService.deportes.get(2))
        );
    }

    @Override
    public List<PersonaDTO> findSportsPersons() {
        List<PersonaDTO> deportistas = new ArrayList<>();
        for(Persona persona: personas){
            PersonaDTO personaDTO = new PersonaDTO(persona.getNombre(), persona.getApellido(), persona.getDeporte().getNombre());
            deportistas.add(personaDTO);
        }
        return deportistas;
    }
}
