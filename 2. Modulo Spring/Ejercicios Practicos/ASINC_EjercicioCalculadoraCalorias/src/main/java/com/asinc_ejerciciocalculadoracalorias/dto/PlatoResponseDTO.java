package com.asinc_ejerciciocalculadoracalorias.dto;

import com.asinc_ejerciciocalculadoracalorias.entidad.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoResponseDTO {
    private String nombre;
    private double cantidadCaloriasTotal;
    private List<IngredienteDTO> listaIngredientesDTO;
    private String ingredienteMasCalorias;
}
