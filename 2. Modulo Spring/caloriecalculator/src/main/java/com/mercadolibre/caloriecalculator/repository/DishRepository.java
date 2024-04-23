package com.mercadolibre.caloriecalculator.repository;

import com.mercadolibre.caloriecalculator.entity.Dish;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DishRepository {
    private List<Dish> dishes;

    public DishRepository(List<Dish> dishes) {
        this.dishes = dishes;
    }
    public List<Dish> findAll() {
        return dishes;
    }
    public void save(Dish dish) {
        dishes.add(dish);
    }
}
