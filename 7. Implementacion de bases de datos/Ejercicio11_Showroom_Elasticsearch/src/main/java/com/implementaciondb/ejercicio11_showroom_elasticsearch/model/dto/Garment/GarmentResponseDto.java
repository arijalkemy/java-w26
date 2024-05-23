package com.implementaciondb.ejercicio11_showroom_elasticsearch.model.dto.Garment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GarmentResponseDto {

    @JsonProperty("code")
    private String code;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("color")
    private String color;

    @JsonProperty("size")
    private Integer size;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("sale_price")
    private Double salePrice;

}
