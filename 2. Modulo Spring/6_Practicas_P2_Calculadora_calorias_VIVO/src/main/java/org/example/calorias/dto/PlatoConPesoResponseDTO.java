package org.example.calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PlatoConPesoResponseDTO {
    private String nombre;
    private int peso;
    private int calorias;
    private List<IngredienteConPesoDTO> ingredientes;
}
