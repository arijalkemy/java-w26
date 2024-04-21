package com.example.ejercicio_arquitectura_multicapa_p2_vivo_calculadora_de_calorias.dto;

public class IngredienteDto {
    private String name;
    private Integer calories;

    public IngredienteDto() {}

    public IngredienteDto(String name, Integer calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }
}
