package org.ggomezr.calculadoradecalorias.application.service.interfaces;

import org.ggomezr.calculadoradecalorias.domain.dto.DishDTO;
import org.ggomezr.calculadoradecalorias.domain.entity.Dish;

import java.util.List;

public interface IDishService {
    Dish getDishByName(String name);
    DishDTO getDishDetails(Dish dish, int grams);

    List<Dish> getAllDishes();

}
