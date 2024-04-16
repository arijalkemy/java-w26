package com.example._04_deportista.servicios;

import com.example._04_deportista.model.DTO.PersonaDeportistaDTO;
import com.example._04_deportista.model.Deporte;
import com.example._04_deportista.model.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService {

    static List<Persona> personas;
    static {
        personas = new ArrayList<>();
        personas.add(new Persona("marcos", "bellotti", 22));
        personas.add(new Persona("jorge", "andrada", 20, new Deporte("futbol", 4)));
        personas.add(new Persona("julian", "alvarez", 25, new Deporte("voley", 4)));
    }

    @Override
    public List<PersonaDeportistaDTO> obtenerPersonas() {
        List<Persona> personasDeportistas =  personas.stream()
                .filter(p->p.getDeporte() != null)
                .toList();

        List<PersonaDeportistaDTO> personasDTO = new ArrayList<>();

        for (Persona persona: personasDeportistas){
            PersonaDeportistaDTO personaDTO = new PersonaDeportistaDTO();

            personaDTO.setNombre(persona.getNombre());
            personaDTO.setApellido(persona.getApellido());
            personaDTO.setNombreDeporte(persona.getDeporte().getNombre());

            personasDTO.add(personaDTO);
        }

        return personasDTO;
    }
}
