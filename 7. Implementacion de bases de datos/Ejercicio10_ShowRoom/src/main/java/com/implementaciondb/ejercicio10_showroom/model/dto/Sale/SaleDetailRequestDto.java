package com.implementaciondb.ejercicio10_showroom.model.dto.Sale;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.implementaciondb.ejercicio10_showroom.model.dto.Garment.GarmentDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleDetailRequestDto {

    @NotNull(message = "La cantidad es requerida")
    @JsonProperty("quantity")
    private Integer quantity;

    @NotNull(message = "El precio es requerido")
    @JsonProperty("price")
    private Double price;

    @Valid
    @NotNull(message = "La prenda es requerida")
    @JsonProperty("garment")
    private GarmentDto garment;
}
