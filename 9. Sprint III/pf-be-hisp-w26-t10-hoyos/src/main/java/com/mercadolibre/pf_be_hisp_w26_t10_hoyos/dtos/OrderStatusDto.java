package com.mercadolibre.pf_be_hisp_w26_t10_hoyos.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderStatusDto {
    @JsonProperty("status_code")
    private String statusCode;
}
