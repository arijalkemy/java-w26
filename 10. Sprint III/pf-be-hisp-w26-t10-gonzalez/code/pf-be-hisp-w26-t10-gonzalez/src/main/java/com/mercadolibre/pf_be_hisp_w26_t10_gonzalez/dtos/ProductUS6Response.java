package com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductUS6Response {
    private Integer operation;
    private String message;
    private Integer code;
}
