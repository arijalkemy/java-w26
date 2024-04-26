package org.mercadolibre.NotNullTeam.service.external;

import org.mercadolibre.NotNullTeam.DTO.request.product.ProductFilterDTO;
import org.mercadolibre.NotNullTeam.DTO.response.product.MainProductResponse;

import java.util.List;

public interface IProductService {
    List<MainProductResponse> searchProducts(ProductFilterDTO productFilterDTO);
}
