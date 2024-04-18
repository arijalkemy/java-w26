package org.ggomezr.calculadoradecalorias.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.ggomezr.calculadoradecalorias.domain.entity.Food;

import java.util.List;

@Getter
@AllArgsConstructor
public class DishDTO {
    private String name;
    private int totalCalories;
    private List<Food> foods;
    private Food foodHigherCalories;
}
