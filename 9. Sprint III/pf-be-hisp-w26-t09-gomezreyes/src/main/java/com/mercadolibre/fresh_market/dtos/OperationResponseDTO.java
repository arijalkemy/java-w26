package com.mercadolibre.fresh_market.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OperationResponseDTO {
    private Integer operation;
    private String message;
    private  Integer code;
}
