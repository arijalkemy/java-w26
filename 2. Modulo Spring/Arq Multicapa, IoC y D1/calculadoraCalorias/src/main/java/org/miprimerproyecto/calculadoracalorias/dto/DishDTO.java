package org.miprimerproyecto.calculadoracalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.miprimerproyecto.calculadoracalorias.model.Ingredient;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DishDTO implements Serializable {
    private String name;
    private int weigthTotal;
    private List<Ingredient> ingredients;



}
