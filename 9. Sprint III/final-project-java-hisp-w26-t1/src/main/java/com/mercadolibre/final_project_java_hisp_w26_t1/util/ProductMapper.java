package com.mercadolibre.final_project_java_hisp_w26_t1.util;

import com.mercadolibre.final_project_java_hisp_w26_t1.dtos.ProductPurchaseDTO;
import com.mercadolibre.final_project_java_hisp_w26_t1.dtos.ProductPurchaseResponseDto;
import com.mercadolibre.final_project_java_hisp_w26_t1.dtos.ProductResponseDTO;
import com.mercadolibre.final_project_java_hisp_w26_t1.entity.Product;

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

    public static ProductPurchaseResponseDto productPurchaseResponseDtoMappingFromProduct(Product product,Integer quantity){
        return ProductPurchaseResponseDto
                .builder()
                .name(product.getName())
                .quantity(quantity)
                .build();
    }

}
