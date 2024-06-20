package com.mercadolibre.project_be_java_hisp_w26_t7.dtos.product;

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
