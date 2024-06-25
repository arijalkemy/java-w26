package com.mercadolibre.project_be_java_hisp_w26_t7.dtos.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListProductRequestDto {
    @Valid
    @JsonProperty("products")
    @NotNull(message = "debe existir una lista de productos")
    @NotEmpty(message = "La lista de productos no puede estar vacia")
    List<ProductRequestDto> products;
}
