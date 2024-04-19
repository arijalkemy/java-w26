package com.w26.countercalories.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@ToString
@AllArgsConstructor
@Getter
@Setter
public class IngredientDish {
    private Dish dish;
    private List<Portion> portionList;
}
