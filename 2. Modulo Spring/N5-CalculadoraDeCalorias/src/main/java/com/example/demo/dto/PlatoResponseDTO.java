package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoResponseDTO {

    private double totalCalorias;
    private List<IngredienteDto> ingredientes;
    private IngredienteDto ingredienteConMasCalorias;

    // Constructor, getters y setters
}
