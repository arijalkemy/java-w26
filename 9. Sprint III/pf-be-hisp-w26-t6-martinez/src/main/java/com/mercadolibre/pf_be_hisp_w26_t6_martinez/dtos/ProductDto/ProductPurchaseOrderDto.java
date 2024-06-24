package com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.ProductDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductPurchaseOrderDto implements Serializable {
    @NotNull(message = "El product_id no puede estar vacío")
    @JsonProperty("product_id")
    private Long productId;
    @NotNull(message = "El campo quantity no puede estar vacío")
    @Min(value = 1, message = "La cantidad minima es de 1 para una orden")
    private Integer quantity;
}
