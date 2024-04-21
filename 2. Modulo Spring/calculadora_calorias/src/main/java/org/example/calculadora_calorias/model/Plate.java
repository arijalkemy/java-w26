package org.example.calculadora_calorias.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.calculadora_calorias.dto.IngredientDTO;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Plate {
    private String name;
    private List<IngredientDTO> ingredients = new ArrayList<>();

}
