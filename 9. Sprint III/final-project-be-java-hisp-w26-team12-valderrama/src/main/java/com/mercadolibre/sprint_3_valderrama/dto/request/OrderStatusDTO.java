package com.mercadolibre.sprint_3_valderrama.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class OrderStatusDTO {
    @JsonProperty("status_code")
    @NotEmpty
    private String status_code;
}
