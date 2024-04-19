package com.w26.countercalories.dto;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
@Getter
@ToString
public class DishDTOInput implements Serializable {
    private String name;
    private int weightInGrams;
}



