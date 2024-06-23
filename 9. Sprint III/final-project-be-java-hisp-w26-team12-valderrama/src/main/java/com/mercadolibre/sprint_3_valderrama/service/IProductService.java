package com.mercadolibre.sprint_3_valderrama.service;

import com.mercadolibre.sprint_3_valderrama.dto.response.ResponseProductDTO;

public interface IProductService {
    ResponseProductDTO selectMethod(String category);
}
