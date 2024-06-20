package com.mercadolibre.fresh_market.dtos.product;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class ProductReqDTO implements Serializable {

    @Valid
    @NotNull(message = "Products cannot be null")
    private List<ProductDetailDTO> products;

}
