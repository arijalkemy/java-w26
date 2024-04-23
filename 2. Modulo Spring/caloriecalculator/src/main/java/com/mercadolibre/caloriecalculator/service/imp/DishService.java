package com.mercadolibre.caloriecalculator.service.imp;

import com.mercadolibre.caloriecalculator.dto.DishResponseDTO;
import com.mercadolibre.caloriecalculator.entity.Dish;
import com.mercadolibre.caloriecalculator.repository.DishRepository;
import com.mercadolibre.caloriecalculator.service.IDishService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishService implements IDishService {
    private final DishRepository dishRepository;
    @Override
    public void registerDish(Dish dish) {
        dishRepository.save(dish);
    }
    public List<DishResponseDTO> getAllDishes() {
        return dishRepository.findAll().stream()
                .map(dish -> new DishResponseDTO(
                        dish.getName(),
                        dish.getIngredients().stream()
                                .mapToDouble(i -> i.getCalories())
                                .sum()

                ))
                .toList();
    }
}
