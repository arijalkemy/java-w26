package org.ggomezr.calculadoradecalorias.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Dish {
    private String name;
    private List<Food> ingredients;
}
