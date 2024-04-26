package org.mercadolibre.NotNullTeam.service.external;

import org.mercadolibre.NotNullTeam.DTO.request.product.ProductFilterDTO;
import org.mercadolibre.NotNullTeam.DTO.response.product.FilterProductsResponse;

public interface IProductService {
    FilterProductsResponse searchProducts(ProductFilterDTO productFilterDTO);
}
