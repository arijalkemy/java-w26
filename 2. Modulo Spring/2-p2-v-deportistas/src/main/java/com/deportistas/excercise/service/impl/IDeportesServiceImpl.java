package com.deportistas.excercise.service.impl;

import com.deportistas.excercise.dto.PersonaDTO;
import com.deportistas.excercise.model.Deporte;
import com.deportistas.excercise.model.Persona;
import com.deportistas.excercise.service.IDeportesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IDeportesServiceImpl implements IDeportesService {

    private List<Persona> personas;
    private List<Deporte> deportes;


    @Override
    public List<Deporte> getDeportes() {
        return this.deportes;
    }

    @Override
    public Deporte getDeporteByName(String nombre) {
        return deportes.stream()
                .filter(deporte -> deporte.getNombre().equalsIgnoreCase(nombre))
                .findFirst().orElse(null);
    }

    public void setDeportes(List<Deporte> deportes){
        this.deportes = deportes;
    }

    public List<PersonaDTO> getPersonasDeportistas(){
        return personas.stream()
                .filter(persona -> persona.getDeporte() != null)
                .map(persona -> new PersonaDTO(persona.getNombre(), persona.getApellido(), persona.getDeporte().getNombre()))
                .collect(Collectors.toList());
    }
}
