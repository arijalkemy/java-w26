package com.ejercicio.calculadoradecalorias.DTO;

import com.ejercicio.calculadoradecalorias.entity.FoodIngredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class FoodResponseDTO implements Serializable {
    private double calories;
    private List<FoodIngredient> foodIngredientList;
}
