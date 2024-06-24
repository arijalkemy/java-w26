package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProductListDTO {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("products")
    private List<ProductDTO> products;
}
