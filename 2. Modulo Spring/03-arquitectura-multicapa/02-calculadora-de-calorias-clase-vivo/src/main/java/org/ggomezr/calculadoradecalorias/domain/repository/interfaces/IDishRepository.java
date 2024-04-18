package org.ggomezr.calculadoradecalorias.domain.repository.interfaces;

import org.ggomezr.calculadoradecalorias.domain.entity.Dish;

import java.util.List;

public interface IDishRepository {

    List<Dish> getAllDishes();
}
