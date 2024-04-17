package org.example.pact_exc_p2_calories_calc.repository;

import org.example.pact_exc_p2_calories_calc.entity.FoodEntity;

import java.util.List;

public interface IFoodRepository {
    public List<FoodEntity> getAllFood();
}
