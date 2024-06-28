package com.mercadolibre.project_be_java_hisp_w26_t7.mapper;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.product.ProductResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.projection.IProductResponseProjection;

import java.math.BigDecimal;
import java.util.List;

public class ProductMapper {

    public static ProductResponseDTO mapToProductResponseDto(IProductResponseProjection product) {
        return ProductResponseDTO.builder()
                .id(product.getId())
                .description(product.getDescription())
                .price(BigDecimal.valueOf(product.getPrice()))
                .sellerName(product.getSellerName())
                .category(product.getCategory())
                .build();
    }

    public static List<ProductResponseDTO> mapList(List<IProductResponseProjection> products) {
        return products.stream().map(ProductMapper::mapToProductResponseDto).toList();
    }
}
