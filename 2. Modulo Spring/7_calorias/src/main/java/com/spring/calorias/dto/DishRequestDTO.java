package com.spring.calorias.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class DishRequestDTO {

    private String name;
    private List<IngredientRequestDTO> ingredients;

    public DishRequestDTO() {}
}
