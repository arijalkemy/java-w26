package com.implementaciondb.ejercicio10_showroom.model.dto.Garment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.implementaciondb.ejercicio10_showroom.model.entity.Garment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GarmentResponseDto extends Garment {

    @JsonProperty("code")
    private Long code;

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
