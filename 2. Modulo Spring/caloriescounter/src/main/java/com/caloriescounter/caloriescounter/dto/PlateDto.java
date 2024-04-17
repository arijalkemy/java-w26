package com.caloriescounter.caloriescounter.dto;

import java.util.List;

import com.caloriescounter.caloriescounter.model.Ingredient;

import lombok.Data;

@Data
public class PlateDto {
    private List<Ingredient> ingredients;
    private double calories;
    private String mostCalories;
}
