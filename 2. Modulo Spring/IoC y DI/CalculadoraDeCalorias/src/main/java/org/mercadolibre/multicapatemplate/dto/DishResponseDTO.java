package org.mercadolibre.multicapatemplate.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.mercadolibre.multicapatemplate.entity.Dish;
import org.mercadolibre.multicapatemplate.entity.Ingredient;

import java.util.List;

@Data
@Setter
@Getter
public class DishResponseDTO {
    private int totalCalories;
    private List<Ingredient> ingredientList;
    private Ingredient mostCaloriesIngredient;

    public DishResponseDTO(Dish dish){
        this.totalCalories = dish.getTotalCalories();
        this.ingredientList = dish.getIngredientList();
        this.mostCaloriesIngredient = dish.getMostCaloriesIngredient();
    }
}
