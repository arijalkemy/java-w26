package com.ejercicio.calculadoraCalorias.service;

import com.ejercicio.calculadoraCalorias.dto.DishDTO;
import com.ejercicio.calculadoraCalorias.model.Dish;
import com.ejercicio.calculadoraCalorias.model.Food;
import com.ejercicio.calculadoraCalorias.repository.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class FoodServiceImpl implements IFoodService{

    @Autowired
    IFoodRepository iFoodRepository;


    @Override
    public DishDTO getDish (String dishName, double weight) {

        Dish dish = iFoodRepository.getDishListByName(dishName);

        double totalCalories = 0;
        String nameFoodMaxCalories = "";
        double maxCalories = 0;

        for(Food food: dish.getFoodList()){

            food.setCalories((food.getCalories()*(weight/100.0)));

            totalCalories += food.getCalories();

            if(food.getCalories()> maxCalories){
                maxCalories = food.getCalories();
                nameFoodMaxCalories = food.getName();
            }
        }


        DishDTO dishDTO = new DishDTO();

        dishDTO.setName(dish.getName());
        dishDTO.setFoodList(dish.getFoodList());
        dishDTO.setTotalCalories(totalCalories);
        dishDTO.setNameFoodMaxCalories(nameFoodMaxCalories);


        return dishDTO;


    }
}
