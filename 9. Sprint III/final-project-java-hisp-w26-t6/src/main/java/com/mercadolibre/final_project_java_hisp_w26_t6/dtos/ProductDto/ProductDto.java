package com.mercadolibre.final_project_java_hisp_w26_t6.dtos.ProductDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.final_project_java_hisp_w26_t6.util.StorageType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {

    @NotNull(message = "El product_id no debe estar vacio")
    @Positive(message = "El product_id no debe ser negativo")
    @JsonProperty("product_id")
    private Long id;

    @NotEmpty(message = "El name no debe estar vacio")
    private String name;

    @NotNull(message = "El price no debe estar vacio")
    @Positive(message = "El price no debe ser negativo")
    private double price;

    @Valid
    private StorageType category;
}
