package com.implementaciondb.ejercicio10_showroom.model.dto.Sale;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.implementaciondb.ejercicio10_showroom.model.dto.Garment.GarmentDto;
import com.implementaciondb.ejercicio10_showroom.model.dto.Garment.GarmentResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleDetailResponseDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("price")
    private Double price;

    @JsonProperty("garment")
    private GarmentResponseDto garment;

}
