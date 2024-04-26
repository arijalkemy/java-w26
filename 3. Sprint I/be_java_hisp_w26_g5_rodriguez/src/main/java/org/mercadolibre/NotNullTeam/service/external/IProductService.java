package org.mercadolibre.NotNullTeam.service.external;

import org.mercadolibre.NotNullTeam.DTO.request.product.ProductFilterDTO;
import org.mercadolibre.NotNullTeam.DTO.response.product.FilterProducts;

public interface IProductService {
    FilterProducts searchProducts(ProductFilterDTO productFilterDTO);
}
