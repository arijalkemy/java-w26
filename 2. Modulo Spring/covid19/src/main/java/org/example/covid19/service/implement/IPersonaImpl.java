package org.example.covid19.service.implement;

import org.example.covid19.dto.PersonaDto;
import org.example.covid19.model.Persona;
import org.example.covid19.model.Sintoma;
import org.example.covid19.service.IPersona;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IPersonaImpl implements IPersona {
    List<Sintoma> sintomas;
    HashMap<Persona,List<Sintoma>> personas;

    public IPersonaImpl() {
        sintomas = Arrays.asList(
                new Sintoma(1, "Dolor de cabeza", "Bajo"),
                new Sintoma(2, "Dolor en los huesos", "Medio"),
                new Sintoma(3, "Problemas para respirar", "Alto"),
                new Sintoma(4, "Fiebre alta", "Alto"),
                new Sintoma(5, "Tos seca persistente", "Alto"),
                new Sintoma(6, "Pérdida del sentido del gusto u olfato", "Alto"),
                new Sintoma(7, "Fatiga extrema", "Alto"),
                new Sintoma(8, "Dolor de garganta", "Medio"),
                new Sintoma(9, "Congestión nasal", "Bajo"),
                new Sintoma(10, "Náuseas o vómitos", "Medio"),
                new Sintoma(11, "Diarrea", "Medio"),
                new Sintoma(12, "Dificultad para concentrarse", "Medio")
        );

        personas = new HashMap<>();
        personas.put(new Persona(1,"Juan","Perez",20),Arrays.asList(sintomas.get(0),
                sintomas.get(5),sintomas.get(10)));

        personas.put(new Persona(1,"Pedro","Martinez",61),Arrays.asList(sintomas.get(2),
                sintomas.get(3),sintomas.get(8),sintomas.get(9)));

        personas.put(new Persona(1,"Juana","Gutierrez",80), new ArrayList<>());

        personas.put(new Persona(1,"Marcos","Salamanca",64),Arrays.asList(sintomas.get(2)));


    }

    @Override
    public List<Sintoma> getAllSintomas() {
        return sintomas;
    }

    @Override
    public Sintoma getSymptomByName(String nombre) {
        return sintomas.stream().filter(sintoma -> sintoma.getNombre().equals(nombre)).
                findFirst().orElse(new Sintoma());
    }

    @Override
    public List<PersonaDto> getRiskPersons() {
        List<PersonaDto> personasList = new ArrayList<>();
        for (Map.Entry<Persona, List<Sintoma>> entry : personas.entrySet()) {
            if (!entry.getValue().isEmpty() && entry.getKey().getEdad() > 60) {
                personasList.add(new PersonaDto(entry.getKey().getNombre(), entry.getKey().getApellido()));
            }
        }
        return personasList;
    }
}
