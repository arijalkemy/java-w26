package com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.product;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreateResponseDto {
    private Long operation;
    private String message;
    private Long code;
}
