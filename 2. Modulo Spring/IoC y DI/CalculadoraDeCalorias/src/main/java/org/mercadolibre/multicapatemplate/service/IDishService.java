package org.mercadolibre.multicapatemplate.service;

import org.mercadolibre.multicapatemplate.dto.DishResponseDTO;

public interface IDishService {

    public DishResponseDTO getDishInfo(String dishName);

}
