package com.mercadolibre.fresh_market.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseUpdateReturnStatusDTO {

    @JsonProperty("returnId")
    private Long returnId;

    private String status;
    private String message;
}
