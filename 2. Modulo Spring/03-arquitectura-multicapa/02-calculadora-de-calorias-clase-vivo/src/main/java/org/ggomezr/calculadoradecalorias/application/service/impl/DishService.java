package org.ggomezr.calculadoradecalorias.application.service.impl;

import org.ggomezr.calculadoradecalorias.application.service.interfaces.IDishService;
import org.ggomezr.calculadoradecalorias.domain.dto.DishDTO;
import org.ggomezr.calculadoradecalorias.domain.entity.Dish;
import org.ggomezr.calculadoradecalorias.domain.repository.impl.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService implements IDishService {

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private FoodService foodService;

    @Override
    public Dish getDishByName(String name) {
        return dishRepository.getAllDishes().stream()
                .filter(dish -> dish.getName().equalsIgnoreCase(name))
                .findFirst().get();
    }

    @Override
    public DishDTO getDishDetails(Dish dish, int grams) {
        return new DishDTO(dish.getName(), foodService.getDishTotalCalories(dish, grams),
                                            dish.getIngredients(),
                                            foodService.getDishHigherCaloriesIngredient(dish));
    }

    @Override
    public List<Dish> getAllDishes() {
        return dishRepository.getAllDishes();
    }
}
