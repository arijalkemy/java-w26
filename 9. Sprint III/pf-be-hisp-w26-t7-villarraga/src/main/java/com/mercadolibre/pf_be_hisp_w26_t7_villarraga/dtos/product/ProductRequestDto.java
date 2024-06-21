package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {
    @Positive
    private Double price;
    @NotEmpty
    private String description;
    @NotEmpty
    @JsonProperty("storage_type")
    private String storageType;
}
