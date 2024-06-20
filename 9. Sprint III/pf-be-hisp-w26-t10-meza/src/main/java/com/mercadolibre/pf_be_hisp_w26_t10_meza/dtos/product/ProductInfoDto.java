package com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfoDto {

    @NotBlank(message = "product_category is required")
    @JsonProperty("product_category")
    Integer productCategory;

    @NotBlank(message = "product_name is required")
    @JsonProperty("product_desc")
    String productName;

    @NotBlank(message = "price is required")
    Double price;
}
