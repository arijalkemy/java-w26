package com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsOperationResponseDTO {
    private Integer operation;
    private String message;
    private Integer code;
}
