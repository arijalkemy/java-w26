package com.meli.calculadoraDeCalorias.service;

import com.meli.calculadoraDeCalorias.dto.DishInputDTO;
import com.meli.calculadoraDeCalorias.dto.DishResponseDTO;
import com.meli.calculadoraDeCalorias.dto.IngredientDTO;
import com.meli.calculadoraDeCalorias.model.Dish;
import com.meli.calculadoraDeCalorias.model.Ingredient;
import com.meli.calculadoraDeCalorias.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class DishServiceImpl implements IDishService{
    @Autowired
    private IRepository<Dish> dishRepository;

    @Override
    public DishResponseDTO getDishInfo(DishInputDTO dishInputDTO) {
        Dish dish = dishRepository.findByName(dishInputDTO.getName());
        if(dish == null) {
            return null;
        }
        Ingredient mostCaloricIngredient = dish.getIngredientList().stream().max(Comparator.comparing(Ingredient::getCalories)).get();
        DishResponseDTO responseDTO = new DishResponseDTO(
                dish.getIngredientList().stream().mapToInt(Ingredient::getCalories).sum() * dishInputDTO.getWeight(),
                dish.getIngredientList().stream().map(ingredient -> new IngredientDTO(ingredient.getName(), ingredient.getCalories() * dishInputDTO.getWeight()))
                        .collect(Collectors.toList()),
                        new IngredientDTO(mostCaloricIngredient.getName(), mostCaloricIngredient.getCalories() * dishInputDTO.getWeight()));
        return responseDTO;
    }
}
