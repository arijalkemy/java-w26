package com.mercadolibre.sprint3_individual_perez.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class CartResponseDTO {
    @JsonProperty("total_price")
    private Double totalPrice;
}
