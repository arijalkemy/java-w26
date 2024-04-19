package com.w26.countercalories.util;

import com.w26.countercalories.entity.Ingredient;

import java.util.List;

public class MapFood {
    private List<Ingredient> ingredientList;

    public MapFood()
    {

    }

    public List<Ingredient> getIngredientList()
    {
        return  ingredientList;
    }
    public void setIngredientList(List<Ingredient> ingredientList)
    {
        this.ingredientList = ingredientList;
    }
}
