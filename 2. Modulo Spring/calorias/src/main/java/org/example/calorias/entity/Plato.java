package org.example.calorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.calorias.dto.IngredienteDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plato {
    private String name;
    private List<Ingrediente> ingredients;
}
