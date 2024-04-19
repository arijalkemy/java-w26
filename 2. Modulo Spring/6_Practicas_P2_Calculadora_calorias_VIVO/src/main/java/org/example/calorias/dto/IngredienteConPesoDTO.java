package org.example.calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class IngredienteConPesoDTO {
    private String nombre;
    private int caloriasPorCada100Gramos;
    private int peso;
    private int calorias;
}
