package org.bootcamp.calorias.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DishResponseDTO {

    private String name;
    private Integer weight;
    private Double totalCalories;
    private List<IngredientDTO> ingredients;
    private IngredientDTO ingredientHighest;

}
