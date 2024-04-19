package org.example.integradorcaloriescalculator.service.impl;


import org.example.integradorcaloriescalculator.dto.DishRequestDTO;
import org.example.integradorcaloriescalculator.dto.DishResponseDTO;
import org.example.integradorcaloriescalculator.entity.Dish;
import org.example.integradorcaloriescalculator.entity.Ingredient;
import org.example.integradorcaloriescalculator.repository.DishRepository;
import org.example.integradorcaloriescalculator.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishServiceImpl implements IDishService<DishResponseDTO, DishRequestDTO> {


    private final DishRepository dishRepository;

    @Autowired
    public DishServiceImpl(DishRepository dishRepository){
        this.dishRepository = dishRepository;
    }


    @Override
    public DishResponseDTO getDataInfo(DishRequestDTO dishRequestDTOs) {

        DishResponseDTO dishInfo = new DishResponseDTO();

        for (Dish dish: dishRepository.getDishes()){
            if (dishRequestDTOs.getDishName().equals(dish.getName())){

                int totalCalories = 0;
                int highestCalorieValue = 0;
                Ingredient highestCalorieIngredient = new Ingredient();

                double calculatedCalories = 0;

                for (Ingredient ingredient :  dish.getIngredients()){
                    totalCalories+=ingredient.getCalories();

                    if (ingredient.getCalories() > highestCalorieValue) {
                        highestCalorieValue = ingredient.getCalories();
                        highestCalorieIngredient = ingredient;
                    }
                }

                calculatedCalories = calculateCalories(totalCalories, dishRequestDTOs.getWeight());

                dishInfo = new DishResponseDTO(
                        dish.getName(),
                        calculatedCalories,
                        dish.getIngredients(),
                        highestCalorieIngredient);
            }
        }
        return dishInfo;
    }

    @Override
    public List<DishResponseDTO> getMassiveInfo(List<DishRequestDTO> requestDTOS) {
        List<DishResponseDTO> responseDTOS = new ArrayList<>();

        for (DishRequestDTO dishRequestDTO : requestDTOS){
            responseDTOS.add(getDataInfo(dishRequestDTO));
        }
        return responseDTOS;
    }

    public double calculateCalories(int ingredientsCalories, double weigth){
        return ((double)ingredientsCalories/100)*weigth;
    }
}
