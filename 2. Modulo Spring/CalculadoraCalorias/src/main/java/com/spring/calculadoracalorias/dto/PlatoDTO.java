package com.spring.calculadoracalorias.dto;

import com.spring.calculadoracalorias.entity.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoDTO {
    private String name;
    private List<Ingrediente> listIngredientes;
    private Double caloriasTotales;
    private String ingredienteMasCalorico;
}
