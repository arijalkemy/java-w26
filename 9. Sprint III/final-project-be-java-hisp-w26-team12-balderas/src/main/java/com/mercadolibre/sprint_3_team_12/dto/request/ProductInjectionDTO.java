package com.mercadolibre.sprint_3_team_12.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductInjectionDTO {

    @JsonProperty("products")
    private List<ProductAddDTO> productAddDTOS;
}
