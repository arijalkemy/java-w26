package com.w26.countercalories.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Dish {
   private String name;
   private int weightInGrams;
}
