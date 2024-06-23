package com.mercadolibre.pf_be_hisp_w26_t01_moises.util;

import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.ProductPurchaseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.ProductPurchaseResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.ProductResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.entity.Product;

public class ProductMapper {

    public static ProductResponseDTO toProductDto(Product product) {
        return ProductResponseDTO.builder()
                .name(product.getName())
                .price(product.getPrice())
                .category(product.getCategory().getName())
                .build();
    }

    public static Product productMappingFromProductPurchaseDto(ProductPurchaseDTO dto){
        return Product
                .builder()
                .id(dto.getProduct_id())
                .build();
    }

    public static ProductPurchaseResponseDto mapToProductPurchaseResponseDto(Product product, Integer quantity){
        return ProductPurchaseResponseDto
                .builder()
                .name(product.getName())
                .quantity(quantity)
                .build();
    }

}
