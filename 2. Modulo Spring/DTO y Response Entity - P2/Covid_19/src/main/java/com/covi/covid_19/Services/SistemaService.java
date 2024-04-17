package com.covi.covid_19.Services;

import com.covi.covid_19.Classes.Persona;
import com.covi.covid_19.Classes.Sintoma;
import com.covi.covid_19.DTO.PersonaSistemaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SistemaService implements ISistemaService{

    @Override
    public void agregarSintoma(Sintoma sintoma) {
        this.sintoma.add(sintoma);
    }

    @Override
    public String conseguirSintomaPorNombre(String nombre) {
        for (Sintoma s : sintoma) {
            if (s.getNombre().equals(nombre)) {
                return s.getCodigo();
            }
        }
        return "No existe el sintoma";
    }

    @Override
    public List<Sintoma> conseguirTodosLosSintomas() {
        return sintoma;
    }

    @Override
    public void agregarPersona(Persona persona) throws Exception {
        if (persona.getEdad() < 0) {
            throw new Exception("La edad no puede ser negativa");
        }
        for (Sintoma s : persona.getSintomas()) {
            if (conseguirSintomaPorNombre(s.getNombre()) == null) {
                throw new Exception("El sintoma " + s.getNombre() + " no existe");
            }
        }
        personas.add(persona);
    }

    @Override
    public List<Persona> conseguirTodasLasPersonas() {
        return personas;
    }

    @Override
    public List<PersonaSistemaDTO> conseguirTodasLasPersonasDTO() {
        return personas.stream()
                .filter(persona -> persona.getSintomas().size() > 0)
                .filter(persona -> persona.getEdad() > 60)
                .map(this::convertirDTO)
                .toList();}

    @Override
    public PersonaSistemaDTO convertirDTO(Persona persona) {
        PersonaSistemaDTO personaSistemaDTO = new PersonaSistemaDTO(
                persona.getNombre(),
                persona.getApellido(),
                persona.getSintomas());
        return personaSistemaDTO;
    }


}
