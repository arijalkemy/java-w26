package org.bootcamp.calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishRequestDTO {

    private String name;
    private Integer weight;
    private List<IngredientDTO> ingredients;


}
