package org.example.calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoIngredienteDTO implements Serializable {
    private String nombre;
    private IngredienteDTO ingredienteMayorCaloria;
}
