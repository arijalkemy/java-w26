package com.ejercicio.calculadoradecalorias.service.interfaces;

import com.ejercicio.calculadoradecalorias.DTO.FoodResponseDTO;
import com.ejercicio.calculadoradecalorias.entity.Food;

public interface IFoodService {
    public FoodResponseDTO createResponse(String foodName, int weight) throws Exception;
}
