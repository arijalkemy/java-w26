package com.mercadolibre.pf_be_hisp_w26_t1_cassini.util;

import com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos.ProductPurchaseDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos.ProductPurchaseResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos.ProductResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.entity.Product;

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
