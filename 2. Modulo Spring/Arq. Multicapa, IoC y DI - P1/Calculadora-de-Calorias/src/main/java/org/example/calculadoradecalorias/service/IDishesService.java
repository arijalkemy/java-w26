package org.example.calculadoradecalorias.service;

import org.example.calculadoradecalorias.dto.DishDTO;
import org.example.calculadoradecalorias.dto.ResponseDTO;

import java.util.List;

public interface IDishesService {
    ResponseDTO calculateCalories(DishDTO dish);
    List<ResponseDTO> calculateCalories(List<DishDTO> dishes);
}
