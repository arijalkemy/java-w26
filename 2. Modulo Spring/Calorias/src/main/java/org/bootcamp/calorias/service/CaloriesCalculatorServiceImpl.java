package org.bootcamp.calorias.service;

import org.bootcamp.calorias.dto.DishDTO;
import org.bootcamp.calorias.model.Dish;
import org.bootcamp.calorias.repository.DishesRepository;
import org.springframework.stereotype.Service;

@Service
public class CaloriesCalculatorServiceImpl implements ICaloriesCalculatorService {
    private final DishesRepository dishesRepository;

    public CaloriesCalculatorServiceImpl(DishesRepository dishesRepository) {
        this.dishesRepository = dishesRepository;
    }

    @Override
    public DishDTO calculateDishCalories(String name, int weight) {
        return dishesRepository.calculateDishCalories(name, weight);
    }
}
