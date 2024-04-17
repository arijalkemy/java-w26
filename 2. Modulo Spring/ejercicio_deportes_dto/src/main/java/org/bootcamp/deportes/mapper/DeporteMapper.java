package org.bootcamp.deportes.mapper;

import org.bootcamp.deportes.domain.Deporte;
import org.bootcamp.deportes.domain.Persona;
import org.bootcamp.deportes.restcontroller.dto.DeporteDTO;
import org.bootcamp.deportes.restcontroller.dto.DeportistasDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class DeporteMapper {

    public DeportistasDTO deportistaADeportistaDTO (Deporte deporte, Persona persona){
        return new DeportistasDTO(deporte.getNombre(), persona.getNombre(), persona.getApellido());
    }

    public List<DeportistasDTO> obtenerDeportistasDTOs(Deporte deporte, List<Persona> personas){
        List<DeportistasDTO> deportistasDTOS = new ArrayList<>();
        personas.forEach(persona -> deportistasDTOS.add(deportistaADeportistaDTO(deporte, persona)));
        return deportistasDTOS;
    }

    public List<DeportistasDTO> mapDeportistaADeporteDTOLista(Map<Deporte, List<Persona>> deportistas){
        List<DeportistasDTO> deportistasDTOs = new ArrayList<>();
        deportistas.forEach((deporte, personas) -> deportistasDTOs.addAll(obtenerDeportistasDTOs(deporte, personas)));
        return deportistasDTOs;
    }

    public DeporteDTO deporteADeporteDTO (Deporte deporte){
        return new DeporteDTO(deporte.getNombre(), deporte.getNivel());
    }

    public List<DeporteDTO> deporteListaADeporteDTOLista (List<Deporte> deportes){
        List<DeporteDTO> deporteDTOs = new ArrayList<>();
        deportes.forEach(deporte -> deporteDTOs.add(deporteADeporteDTO(deporte)));
        return deporteDTOs;
    }

}
