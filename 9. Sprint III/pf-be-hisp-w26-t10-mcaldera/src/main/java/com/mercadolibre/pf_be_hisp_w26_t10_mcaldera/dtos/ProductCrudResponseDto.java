package com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCrudResponseDto {
    private Integer operation;
    private String message;
    private Integer code;
}
