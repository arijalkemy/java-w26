package com.example._05_covid19.service;

import com.example._05_covid19.model.DTO.PersonaConSintomaDTO;
import com.example._05_covid19.model.Persona;
import com.example._05_covid19.model.Sintoma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService{
    private static List<Persona> personas;
    static {
        List<Sintoma> sintomas = new ArrayList<>();
        sintomas.add(new Sintoma(1, "Dolor de cuello", 5));

        personas = new ArrayList<>();
        personas.add(new Persona(1, "Sonia", "Grande", 55, sintomas));
        personas.add(new Persona(2, "Raul", "Pei", 74, sintomas));
        personas.add(new Persona(3, "Lorena", "Astei", 61, sintomas));

    }

    @Override
    public List<PersonaConSintomaDTO> obtenerGrupoDeRiesgo() {
        List<Persona> personasEnRiesgo = personas.stream()
                .filter(p->p.getEdad()>=60)
                .toList();

        List<PersonaConSintomaDTO> personaConSintomaDTOS = new ArrayList<>();

        for (Persona persona: personasEnRiesgo){
            PersonaConSintomaDTO personaSintoma = new PersonaConSintomaDTO();
            personaSintoma.setNombre(persona.getNombre());
            personaSintoma.setApellido(persona.getApellido());

            List<String> nombreDeSintomas = persona
                    .getSintomas().stream()
                    .map(sintoma -> sintoma.getNombre())
                    .toList();

            personaSintoma.setNombresDeSintomas(nombreDeSintomas);

            personaConSintomaDTOS.add(personaSintoma);
        }

        return personaConSintomaDTOS;
    }
}
