package com.meli.calculadoraDeCalorias.repository;

import com.meli.calculadoraDeCalorias.model.Dish;

public interface IDishRepository {

    Dish getByNameAndWeight(String name, double weight);

    void saveDish(Dish dish);
}
