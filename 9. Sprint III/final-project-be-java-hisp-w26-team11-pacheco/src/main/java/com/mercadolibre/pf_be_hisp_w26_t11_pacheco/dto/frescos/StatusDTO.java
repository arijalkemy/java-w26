package com.mercadolibre.pf_be_hisp_w26_t11_pacheco.dto.frescos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusDTO {
    @JsonProperty("status_code")
    private String statusCode;
}
