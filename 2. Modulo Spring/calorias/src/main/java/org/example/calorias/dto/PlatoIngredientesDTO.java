package org.example.calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoIngredientesDTO {
    private String nombre;
    private List<IngredienteDTO> ingredientes;

}

