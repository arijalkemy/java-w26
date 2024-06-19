package com.mercadolibre.fresh_market.service;

import com.mercadolibre.fresh_market.dtos.BatchLocationResponseDTO;
import com.mercadolibre.fresh_market.dtos.ExpiringProductResponseDTO;

public interface IBatchService {

    ExpiringProductResponseDTO getBatchesExpiringSoon(Integer countDays);

    ExpiringProductResponseDTO getBatchesExpiringSoonByCategoryAndOrder(Integer countDays, String category,
                                                                        String order);


    BatchLocationResponseDTO getBatchByProductId(Long idProduct);
    BatchLocationResponseDTO getBatchByProductIdOrdered(Long idProduct, String order);

}
