package com.mercadolibre.pf_be_hisp_w26_t01_moises.utils;

import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.ProductPurchaseResponseDto;

public class ProductPurchaseDtoBuilder {
    public static ProductPurchaseResponseDto getResponseDto() {
        return ProductPurchaseResponseDto.builder()
                .name("Manzana")
                .quantity(5)
                .build();
    }
    public static ProductPurchaseResponseDto getResponseDto(int quantity) {
        return ProductPurchaseResponseDto.builder()
                .name("Manzana")
                .quantity(quantity)
                .build();
    }
}
