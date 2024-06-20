package com.mercadolibre.sprint_3_team_12.service;

import com.mercadolibre.sprint_3_team_12.dto.request.ProductAddDTO;
import com.mercadolibre.sprint_3_team_12.dto.request.ProductInjectionDTO;
import com.mercadolibre.sprint_3_team_12.dto.response.MessageDTO;
import com.mercadolibre.sprint_3_team_12.dto.response.ResponseProductDTO;

public interface IProductService {
    ResponseProductDTO selectMethod(String category);

    MessageDTO postProducts(ProductInjectionDTO productInjectionDTO);

    MessageDTO updateProduct(ProductAddDTO productAddDTO);
}
