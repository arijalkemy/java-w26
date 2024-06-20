package com.mercadolibre.fresh_market.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseCreateReturnDTO {

    private Long returnId;
    private String status;
    private String message;

}
