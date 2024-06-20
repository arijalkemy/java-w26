package com.mercadolibre.fresh_market.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestUpdateReturnStatusDTO {

    private String status;
    private String comments;
}
