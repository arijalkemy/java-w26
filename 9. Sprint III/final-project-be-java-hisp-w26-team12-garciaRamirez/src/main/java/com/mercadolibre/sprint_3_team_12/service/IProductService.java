package com.mercadolibre.sprint_3_team_12.service;

import com.mercadolibre.sprint_3_team_12.dto.request.ProductCreationDTO;
import com.mercadolibre.sprint_3_team_12.dto.request.ProductCreationListRequestDTO;
import com.mercadolibre.sprint_3_team_12.dto.response.ProductCreationResponseDTO;
import com.mercadolibre.sprint_3_team_12.dto.response.ResponseProductDTO;

public interface IProductService {
    ResponseProductDTO selectMethod(String category);
    ProductCreationResponseDTO postProduct(ProductCreationListRequestDTO productCreationDTO, Long idSeller);
    ProductCreationResponseDTO updateProduct(Long idProduct, ProductCreationDTO productCreationtDTO, Long idSeller);
}
