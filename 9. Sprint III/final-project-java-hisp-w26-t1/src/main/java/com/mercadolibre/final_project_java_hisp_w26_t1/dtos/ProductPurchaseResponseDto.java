package com.mercadolibre.final_project_java_hisp_w26_t1.dtos;

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
