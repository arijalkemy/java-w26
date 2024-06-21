package com.mercadolibre.project_be_java_hisp_w26_team4.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderStatusRequestDTO {
    @JsonProperty("status_code")
    @NotNull(message = "Status cannot be null")
    private String statusCode;
}
