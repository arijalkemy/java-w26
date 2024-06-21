package com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos;

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
