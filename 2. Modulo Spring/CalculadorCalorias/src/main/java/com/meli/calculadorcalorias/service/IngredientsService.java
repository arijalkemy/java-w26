package com.meli.calculadorcalorias.service;

import com.meli.calculadorcalorias.dto.DishDTO;
import com.meli.calculadorcalorias.dto.DishReturnDTO;
import com.meli.calculadorcalorias.dto.IngredientsDTO;
import com.meli.calculadorcalorias.dto.IngredientsReturnDTO;
import com.meli.calculadorcalorias.model.Ingredients;

import java.util.List;

public interface IngredientsService {

    public List<IngredientsReturnDTO> ReMapIngredints(List<IngredientsDTO> list);
    public DishReturnDTO ReturnDish(DishDTO dishDTO);
    public double calculateCalories(List<IngredientsReturnDTO> ingredients);
    public void saveDish(DishReturnDTO dish);
    public DishReturnDTO getDish(String name);


}
