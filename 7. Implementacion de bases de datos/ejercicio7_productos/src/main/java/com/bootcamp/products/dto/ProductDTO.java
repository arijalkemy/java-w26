package com.bootcamp.products.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProductDTO implements Serializable {

    private String id;
    private String name;
    private Integer amount;

    @JsonProperty("cost_price")
    private Double costPrice;

    @JsonProperty("sale_price")
    private Double salePrice;

}
