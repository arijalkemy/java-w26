package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderStatusRequestDTO {

    @JsonProperty("status_code")
    @NotBlank(message = "Status code is required")
    private String statusCode;

}
