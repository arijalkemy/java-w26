package com.w26.countercalories.service;

import com.w26.countercalories.dto.DishDTOInput;
import com.w26.countercalories.dto.DishDTOOutput;
import com.w26.countercalories.entity.Ingredient;
import com.w26.countercalories.entity.IngredientDish;
import com.w26.countercalories.entity.Portion;
import com.w26.countercalories.repository.IngredientDishRepository;
import com.w26.countercalories.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class DishIngredientService {

    @Autowired
    private IngredientDishRepository ingredientDishRepository;
    public DishDTOOutput getDishInfo(DishDTOInput request)
    {
        DishDTOOutput dtoOut = new DishDTOOutput();
        Optional<IngredientDish> ingredientDish  = ingredientDishRepository.getIngredientDishList().stream().filter(ingredientDishIT -> ingredientDishIT.getDish().getName().equals(request.getName())).findFirst();

        if(ingredientDish.isPresent())
        {
            IngredientDish ingredientDishFilter = ingredientDish.get();
            dtoOut.setIngredientDishList(ingredientDishFilter);
            dtoOut.setWeightInGrams(ingredientDishFilter.getDish().getWeightInGrams());

            float sum = 0;

            Ingredient major = null;
            float majorCalories = 0f;

            for (Portion portion: ingredientDishFilter.getPortionList()) {

                float caloriesIngredient = portion.calculateCalories(ingredientDishFilter.getDish().getWeightInGrams());
                sum += caloriesIngredient;

                if (major == null)
                {
                    major = portion.getIngredient();
                    majorCalories = caloriesIngredient;
                } else if (majorCalories < caloriesIngredient) {
                    majorCalories = caloriesIngredient;
                    major = portion.getIngredient();
                }
            }
            dtoOut.setTotalCalories(sum);
            dtoOut.setMajorCalories(major);
        }
        return dtoOut;
    }

    public List<DishDTOOutput> getDishesInfo(List<DishDTOInput> request)
    {
        List<DishDTOOutput> listDishesInfo = new ArrayList<>();

        for (DishDTOInput dishInput: request) {
            listDishesInfo.add( this.getDishInfo(dishInput));
        }

        return  listDishesInfo;
    }
}
