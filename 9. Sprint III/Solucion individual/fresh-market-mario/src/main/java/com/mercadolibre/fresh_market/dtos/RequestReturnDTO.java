package com.mercadolibre.fresh_market.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestReturnDTO {

    @JsonProperty("orderId")
    private Long orderId;

    @JsonProperty("productId")
    private Long productId;

    private String reason;
    private String details;

}
