package org.mercadolibre.multicapatemplate.service.impl;

import org.mercadolibre.multicapatemplate.dto.DishResponseDTO;
import org.mercadolibre.multicapatemplate.repository.DishRepository;
import org.mercadolibre.multicapatemplate.service.IDishService;
import org.springframework.stereotype.Service;

@Service
public class DishServiceImpl implements IDishService {
    DishRepository dishRepository;
    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }
    public DishResponseDTO getDishInfo(String dishName){
        return new DishResponseDTO(this.dishRepository.getFoodPlateWith(dishName));
    }
}
