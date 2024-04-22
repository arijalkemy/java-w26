package org.miprimerproyecto.calculadoracalorias.service;

import org.miprimerproyecto.calculadoracalorias.dto.DishDTO;
import org.miprimerproyecto.calculadoracalorias.model.Ingredient;

public interface IDishService {
    String getDish(String name, int weigth);
}
