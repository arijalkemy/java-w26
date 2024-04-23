package com.demospring.calculadoradecalorias.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter @Setter
public class PlatoRequestDTO {
    private String nombre;
    private List<IngredienteDTO> ingredientes;

    public PlatoRequestDTO(String nombre, List<IngredienteDTO> ingredientes) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
    }
}
