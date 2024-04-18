package org.bootcamp.calorias.service;

import org.bootcamp.calorias.dto.DishRequestDTO;
import org.bootcamp.calorias.dto.DishResponseDTO;
import org.bootcamp.calorias.model.Dish;

import java.util.List;

public interface DishService {

    List<DishResponseDTO> getAll();
    DishResponseDTO getTotalCalories(DishRequestDTO dishRequestDTO);

    DishResponseDTO saveDish(DishRequestDTO dishRequestDTO);

    List<DishResponseDTO> saveDishAll (List<DishRequestDTO> dishRequestDTOList);

}
