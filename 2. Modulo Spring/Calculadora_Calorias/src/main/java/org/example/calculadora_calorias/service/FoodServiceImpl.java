package org.example.calculadora_calorias.service;

import org.example.calculadora_calorias.dto.EntryFoodList;
import org.example.calculadora_calorias.dto.FoodDTO;
import org.example.calculadora_calorias.model.Food;
import org.example.calculadora_calorias.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodServiceI {

    @Autowired
    FoodRepository foodRepository;
    @Override
    public FoodDTO getFoodInfo(String foodName) {
        return new FoodDTO(foodRepository.getFoodByName(foodName).getIngredients(), foodName);
    }

    @Override
    public List<FoodDTO> getFoodListByNames(EntryFoodList foodNames) {
        return foodRepository.getFoodListByNames(foodNames).stream()
                .map(food -> new FoodDTO(food.getIngredients(), food.getName()))
                .toList();
    }


}
