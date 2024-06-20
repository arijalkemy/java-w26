package com.mercadolibre.sprint_3_team_12.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class NotificationDTO {
    @JsonProperty("product_id")
    private Integer productId;

    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("current_stock")
    private Integer currentStock;

    @JsonProperty("minimum_stock")
    private Integer minimumStock;

    @JsonProperty("message")
    private String message;
}
