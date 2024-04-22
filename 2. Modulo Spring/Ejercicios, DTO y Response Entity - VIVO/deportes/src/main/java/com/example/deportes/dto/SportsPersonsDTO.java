package com.example.deportes.dto;

import com.example.deportes.entity.Inscripcion;
import lombok.Data;

import java.util.List;
@Data
public class SportsPersonsDTO {
    private String fullname;
    private List<String> sport;

    public SportsPersonsDTO(Inscripcion inscripcion){
        this.fullname = inscripcion.getPersona().getNombre() + " " + inscripcion.getPersona().getApellido();
        this.sport = inscripcion.getDeportes().stream().map(deporte -> deporte.getNombre()).toList();
    }
}
