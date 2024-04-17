package com.meli.calculadoraDeCalorias.service;

import com.meli.calculadoraDeCalorias.dto.DishInputDTO;
import com.meli.calculadoraDeCalorias.dto.DishResponseDTO;
import org.springframework.stereotype.Service;

public interface IDishService {
    DishResponseDTO getDishInfo(DishInputDTO dishInputDTO);
}
