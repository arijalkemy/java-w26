package com.mercadolibre.fresh_market.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDTO {
    @JsonProperty("productId")
    Long productId;
    int quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO product = (ProductDTO) o;
        return this.productId == product.getProductId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productId);
    }
}
