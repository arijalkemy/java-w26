package com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class ProductPurchaseResponseDto {
    String name;
    Integer quantity;
}
