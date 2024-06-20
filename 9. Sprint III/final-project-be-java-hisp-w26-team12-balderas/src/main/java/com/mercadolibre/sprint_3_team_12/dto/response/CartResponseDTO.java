package com.mercadolibre.sprint_3_team_12.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class CartResponseDTO {
    @JsonProperty("total_price")
    private Double totalPrice;
}
