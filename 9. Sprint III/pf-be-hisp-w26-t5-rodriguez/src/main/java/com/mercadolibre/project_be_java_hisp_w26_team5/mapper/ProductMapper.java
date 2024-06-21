package com.mercadolibre.project_be_java_hisp_w26_team5.mapper;

import com.mercadolibre.project_be_java_hisp_w26_team5.dto.response.ProductDetailResponseDto;
import com.mercadolibre.project_be_java_hisp_w26_team5.model.Product;

import java.util.List;

public class ProductMapper {

    public static ProductDetailResponseDto toProductDetailResponseDto(Product product) {
        return ProductDetailResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .type(product.getType())
                .creationDate(product.getCreationDate())
                .build();
    }

    public static List<ProductDetailResponseDto> toProductDetailResponseDtoList(List<Product> products) {
        return products.stream().map(ProductMapper::toProductDetailResponseDto).toList();
    }
}
