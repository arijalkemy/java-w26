package com.meli.calculadoraDeCalorias.repository;

import com.meli.calculadoraDeCalorias.model.Dish;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DishRepository implements IDishRepository {

    List<Dish> dishList = new ArrayList<>();

    public void saveDish(Dish dish){
        dishList.add(dish);
    }

    public Dish getByNameAndWeight(String name, double weight) {
        return dishList.stream()
                .filter(dish -> dish.getName().equals(name) && dish.getWeight() == weight)
                .findFirst()
                .orElse(null);
    }

}
