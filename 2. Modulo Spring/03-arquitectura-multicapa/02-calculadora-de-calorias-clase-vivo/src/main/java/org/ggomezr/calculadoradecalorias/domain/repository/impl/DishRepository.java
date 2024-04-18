package org.ggomezr.calculadoradecalorias.domain.repository.impl;

import org.ggomezr.calculadoradecalorias.application.service.impl.FoodService;
import org.ggomezr.calculadoradecalorias.domain.dto.DishDTO;
import org.ggomezr.calculadoradecalorias.domain.entity.Dish;
import org.ggomezr.calculadoradecalorias.domain.repository.interfaces.IDishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Repository
public class DishRepository implements IDishRepository {

    @Autowired
    private FoodRepository foodRepository;

    private List<Dish> dishes;

    public DishRepository(FoodRepository foodRepository) throws IOException {
        this.foodRepository = foodRepository;
        this.dishes = this.dishes = Arrays.asList(
                new Dish("Pizza", Arrays.asList(
                        foodRepository.getAllIngredients().get(13),
                        foodRepository.getAllIngredients().get(95),
                        foodRepository.getAllIngredients().get(31),
                        foodRepository.getAllIngredients().get(88),
                        foodRepository.getAllIngredients().get(0)
                )),

                new Dish("Batido", Arrays.asList(
                        foodRepository.getAllIngredients().get(76),
                        foodRepository.getAllIngredients().get(66),
                        foodRepository.getAllIngredients().get(71)
                )),

                new Dish("Ensalada", Arrays.asList(
                        foodRepository.getAllIngredients().get(19),
                        foodRepository.getAllIngredients().get(37),
                        foodRepository.getAllIngredients().get(29),
                        foodRepository.getAllIngredients().get(0),
                        foodRepository.getAllIngredients().get(1)
                ))
        );
    }

    @Override
    public List<Dish> getAllDishes() {
        return dishes;
    }
}
