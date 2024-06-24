package com.mercadolibre.final_project_java_hisp_w26_t6.dtos.PurchaseOrderDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatusDto implements Serializable {
    @NotEmpty(message = "El status_code no puede estar vacío")
    @JsonProperty("status_code")
    private String statusCode;
}
