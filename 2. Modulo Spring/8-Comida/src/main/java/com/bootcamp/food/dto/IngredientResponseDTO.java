package com.bootcamp.food.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class IngredientResponseDTO implements Serializable {
    public String name;
    public Integer calories;
}
