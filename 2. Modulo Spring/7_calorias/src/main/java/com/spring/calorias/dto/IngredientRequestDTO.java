package com.spring.calorias.dto;

import lombok.Getter;

@Getter
public class IngredientRequestDTO {

    private String name;
    private Double weight;

    public IngredientRequestDTO(String name, Double weight) {
        this.name = name;
        this.weight = weight;
    }

}
