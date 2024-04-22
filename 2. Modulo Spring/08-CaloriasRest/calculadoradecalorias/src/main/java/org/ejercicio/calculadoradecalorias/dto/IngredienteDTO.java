package org.ejercicio.calculadoradecalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class IngredienteDTO {
    private String nombre;
    private int peso;
    private double calorias;
}
