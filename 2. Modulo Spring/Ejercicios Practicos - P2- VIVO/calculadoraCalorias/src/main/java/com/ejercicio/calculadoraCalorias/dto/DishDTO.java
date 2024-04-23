package com.ejercicio.calculadoraCalorias.dto;

import com.ejercicio.calculadoraCalorias.model.Food;

import java.util.List;

public class DishDTO {

    String name;
    double totalCalories;
    List<Food> foodList;
    String nameFoodMaxCalories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public String getNameFoodMaxCalories() {
        return nameFoodMaxCalories;
    }

    public void setNameFoodMaxCalories(String nameFoodMaxCalories) {
        this.nameFoodMaxCalories = nameFoodMaxCalories;
    }
}
