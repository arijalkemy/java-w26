package org.bootcamp.calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class IngredientDTO {
    private String name;
    private Integer calories;
}