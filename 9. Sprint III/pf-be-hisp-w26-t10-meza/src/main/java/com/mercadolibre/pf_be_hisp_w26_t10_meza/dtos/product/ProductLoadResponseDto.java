package com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.product;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductLoadResponseDto {
    Integer operation;
    String message;
    Integer code;
}
