package com.mercadolibre.fresh_market.util.mapper;

import com.mercadolibre.fresh_market.dtos.ProductDetailDTO;
import com.mercadolibre.fresh_market.model.Product;

public class ProductMapper {
    public ProductDetailDTO productToProductDetailDTO(Product product){
        return ProductDetailDTO.builder()
                .id(product.getId())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
