package com.meli.calculadoracalorias_vivo.dto;

import com.meli.calculadoracalorias_vivo.entity.Ingredients;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor @Setter @Getter
public class IngredientsDTO {
    private String name;
    private Double calories;
}
