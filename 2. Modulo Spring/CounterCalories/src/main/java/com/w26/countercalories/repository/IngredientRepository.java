package com.w26.countercalories.repository;

import com.w26.countercalories.entity.Ingredient;
import com.w26.countercalories.util.FoodLoader;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class IngredientRepository {
    private @Getter List<Ingredient> ingredientList;

    @Autowired
    private FoodLoader foodLoader;

    public IngredientRepository(FoodLoader foodLoader)
    {
        this.ingredientList = foodLoader.getIngredientList();
        this.foodLoader = foodLoader;
    }

    public Ingredient ingredientByName(String nameIngredient)
    {
        Optional<Ingredient> ingredient =  ingredientList.stream().filter(ingredientI -> ingredientI.getName().equals(nameIngredient)).findFirst();
        if (ingredient.isPresent())
            return ingredient.get();
        return null;
    }
}
