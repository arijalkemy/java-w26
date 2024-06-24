package com.mercadolibre.project_java_w26_team13.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartResponseDto {
    @JsonProperty("total_price")
    Double totalPrice;
    @JsonProperty("products_without_stock")
    List<String> productsWithoutStock;
}
