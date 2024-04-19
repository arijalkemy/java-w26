package org.example.calorias.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IngredienteDTO {
    private String nombre;
    private int caloriasPorCada100Gramos;
}
