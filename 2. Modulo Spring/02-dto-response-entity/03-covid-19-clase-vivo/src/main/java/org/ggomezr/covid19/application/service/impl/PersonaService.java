package org.ggomezr.covid19.application.service.impl;

import org.ggomezr.covid19.domain.dto.PersonaRiesgoDTO;
import org.ggomezr.covid19.domain.entity.Persona;
import org.ggomezr.covid19.domain.entity.Sintoma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private SintomaService sintomaService;

    public List<PersonaRiesgoDTO> findRiskPerson(){
        List<PersonaRiesgoDTO> personasRiesgo = new ArrayList<>();
        for(Persona persona : sintomaService.personas){
            if(persona.getEdad() > 60 && tieneSintomas(persona)){
                personasRiesgo.add(new PersonaRiesgoDTO(persona.getNombre(), persona.getApellido(), persona.getEdad()));
            }
        }
        return personasRiesgo;
    }

    private boolean tieneSintomas(Persona persona){
        for (Sintoma sintoma: sintomaService.sintomas){
            if(sintoma.getIdPersona() == persona.getId()){
                return true;
            }
        }
        return false;
    }
}
