package org.example.calories.repositories;

import lombok.Getter;
import org.example.calories.entities.Food;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Getter
public class FoodRepository {
    private final List<Food> foodList;

    public FoodRepository(@Qualifier("foodList") List<Food> foodList) {
        this.foodList = foodList;
    }
}
