package com.mercadolibre.CalculadoraDeCalorias.service;

import com.mercadolibre.CalculadoraDeCalorias.dto.DishDTO;

import java.util.List;

public interface IDishService {
    DishDTO findDish(String name);
}
