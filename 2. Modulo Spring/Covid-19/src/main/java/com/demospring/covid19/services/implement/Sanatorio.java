package com.demospring.covid19.services.implement;

import com.demospring.covid19.dtos.PersonaConSintomaDTO;
import com.demospring.covid19.models.Persona;
import com.demospring.covid19.models.Sintoma;
import com.demospring.covid19.repositories.PersonaDB;
import com.demospring.covid19.repositories.SintomasDB;
import com.demospring.covid19.services.ISanatorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Sanatorio implements ISanatorio {
    @Override
    public List<Sintoma> getSintomas() {
        return SintomasDB.getSintomas();
    }

    @Override
    public Sintoma getSintoma(int codigo) {
        return SintomasDB.getSintomas().stream().filter(sintoma -> sintoma.getCodigo() == codigo).findFirst().get();
    }

    @Override
    public List<PersonaConSintomaDTO> getPersonasConSintomas() {
        List<PersonaConSintomaDTO> personaConSintomaDTOS = new ArrayList<>();
        List<Persona> personas = PersonaDB.getPersonas();
        for (Persona persona : personas) {
            if(persona.getEdad() >= 60){
                personaConSintomaDTOS.add(new PersonaConSintomaDTO(persona.getNombre(), persona.getApellido(), getSintoma(persona.getSintoma()).getNombre()));
            }
        }
        return personaConSintomaDTOS;
    }
}
