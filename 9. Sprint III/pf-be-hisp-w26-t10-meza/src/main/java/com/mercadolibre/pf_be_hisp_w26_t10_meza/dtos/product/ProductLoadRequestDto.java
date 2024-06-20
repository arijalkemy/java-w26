package com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductLoadRequestDto {

    @NotBlank(message = "product list is required")
    @JsonProperty("products")
    List<ProductInfoDto> productInfoDtoList;
}
