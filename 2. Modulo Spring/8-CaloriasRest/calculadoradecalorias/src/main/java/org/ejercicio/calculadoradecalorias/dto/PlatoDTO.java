package org.ejercicio.calculadoradecalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class PlatoDTO {
    private String nombre;
    private List<IngredienteDTO> ingredienteDTOS;
}
