package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.product;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductCreateResponseDto {
    private Long operation;
    private String message;
    private Long code;
}
