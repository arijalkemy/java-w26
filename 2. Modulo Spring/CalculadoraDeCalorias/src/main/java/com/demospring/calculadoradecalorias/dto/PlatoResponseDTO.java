package com.demospring.calculadoradecalorias.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PlatoResponseDTO {
    private String nombrePlato;
    private int totalCalorias;

    public PlatoResponseDTO(String nombrePlato, int totalCalorias) {
        this.nombrePlato = nombrePlato;
        this.totalCalorias = totalCalorias;
    }
}
