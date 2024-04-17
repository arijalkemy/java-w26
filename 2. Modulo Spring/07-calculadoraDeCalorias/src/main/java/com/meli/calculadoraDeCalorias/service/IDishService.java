package com.meli.calculadoraDeCalorias.service;

import com.meli.calculadoraDeCalorias.dto.DishRequestDTO;
import com.meli.calculadoraDeCalorias.dto.DishResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IDishService {
    DishResponseDTO getDishInfo(DishRequestDTO dishRequestDTO);
    List<DishResponseDTO> getDishesInfo(List<DishRequestDTO> dishRequestDTOList);
}
