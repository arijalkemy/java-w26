package com.mercadolibre.fresh_market.dtos.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDTO implements Serializable {

    @JsonProperty("productId")
    private Long productId;
    private int quantity;

}
