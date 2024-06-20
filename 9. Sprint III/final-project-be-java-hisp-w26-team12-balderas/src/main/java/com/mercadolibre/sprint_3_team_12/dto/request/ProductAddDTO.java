package com.mercadolibre.sprint_3_team_12.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.sprint_3_team_12.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductAddDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("product_desc")
    private String productDesc;

    @JsonProperty("price")
    private Double price;

    @JsonProperty("type")
    private Category type;
}
