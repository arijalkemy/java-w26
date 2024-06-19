package com.mercadolibre.sprint_3_team_12.service;

import com.mercadolibre.sprint_3_team_12.dto.request.ProductNameDTO;
import com.mercadolibre.sprint_3_team_12.dto.response.ResponseProductDTO;

import java.util.List;

public interface IProductService {
    ResponseProductDTO selectMethod(String category);

    Object postProduct(ProductNameDTO newProduct);

    Object putProduct(ProductNameDTO product);

    List<ProductNameDTO> getAllProductsWithName();
}
