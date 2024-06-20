package com.mercadolibre.fresh_market.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseReturnsDTO {

    @JsonProperty("return_id")
    private Long returnId;

    private String status;

    @JsonProperty("order_id")
    private Long orderId;

    @JsonProperty("product_id")
    private Long productId;

    private String reason;

    private String comments;

    private LocalDateTime timestamp;


}
