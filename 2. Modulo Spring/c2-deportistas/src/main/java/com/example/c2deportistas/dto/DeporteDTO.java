package com.example.c2deportistas.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeporteDTO {
    private String nombre;

    public DeporteDTO(String nombre) {
        this.nombre = nombre;
    }
}
