package org.example.calculadora_calorias.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.calculadora_calorias.model.Ingredient;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@JsonPropertyOrder({"name", "totalCalories"})
public class FoodDTO implements Serializable {
    List<Ingredient> ingredients;
    String name;
    int totalCalories;
    Ingredient mayorIngredient;

    public FoodDTO(List<Ingredient> _ingredients, String foodName){
            ingredients = _ingredients;
            name = foodName;
            totalCalories = getTotalCalories();
            mayorIngredient = getMayorIngredient();
    }

    public int getTotalCalories(){
        return ingredients.stream().mapToInt(Ingredient::getCalories).sum();
    }

    public Ingredient getMayorIngredient(){
        Ingredient mayorOne = new Ingredient();
        for(Ingredient ingredient : ingredients){
            if(mayorOne.getCalories() < ingredient.getCalories()){
                mayorOne = ingredient;
            }
        }
        return mayorOne;
    }
}
