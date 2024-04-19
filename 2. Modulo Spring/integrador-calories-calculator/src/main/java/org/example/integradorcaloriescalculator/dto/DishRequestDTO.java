package org.example.integradorcaloriescalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class DishRequestDTO {

    private String dishName;
    private double weight;


    public DishRequestDTO(){}
}
