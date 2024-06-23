package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.mapper;

import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.response.ProductDetailResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.Product;

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
