package com.mercadolibre.sprint_3_team_12.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data @AllArgsConstructor @JsonPropertyOrder({"idProduct", "quantity"})


public class ProductDTO {

    @NotNull
    @NotEmpty
    @Positive
    @JsonProperty("product_id")
    private Integer idProduct;

    @NotNull @NotEmpty @Positive
    @JsonProperty("quantity")
    private Integer quantity;
}
