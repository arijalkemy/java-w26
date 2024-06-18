package com.mercadolibre.sprint_3_team_12.service;

import com.mercadolibre.sprint_3_team_12.dto.response.ResponseProductDTO;

public interface IProductService {
    ResponseProductDTO selectMethod(String category);
}
