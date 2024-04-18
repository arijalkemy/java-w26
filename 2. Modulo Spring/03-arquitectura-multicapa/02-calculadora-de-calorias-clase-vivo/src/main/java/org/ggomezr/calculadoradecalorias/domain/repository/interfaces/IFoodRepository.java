package org.ggomezr.calculadoradecalorias.domain.repository.interfaces;

import org.ggomezr.calculadoradecalorias.domain.entity.Food;

import java.io.IOException;
import java.util.List;

public interface IFoodRepository {
    List<Food> getAllIngredients() throws IOException;
}
