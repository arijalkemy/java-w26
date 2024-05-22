package com.implementaciondb.ejercicio10_showroom.model.dto.Garment;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GarmentRequestDto {

    @NotNull(message = "El nombre es requerido")
    @Size(max = 100, message = "El nombre no puede tener más de 100 caracteres")
    @JsonProperty("name")
    private String name;

    @NotNull(message = "El tipo es requerido")
    @Size(max = 50, message = "El tipo no puede tener más de 50 caracteres")
    @JsonProperty("type")
    private String type;

    @NotNull(message = "La marca es requerida")
    @Size(max = 50, message = "La marca no puede tener más de 50 caracteres")
    @JsonProperty("brand")
    private String brand;

    @NotNull(message = "El color es requerido")
    @Size(max = 30, message = "El color no puede tener más de 30 caracteres")
    @JsonProperty("color")
    private String color;

    @NotNull(message = "El tamaño es requerido")
    @JsonProperty("size")
    private Integer size;

    @NotNull(message = "La cantidad es requerida")
    @JsonProperty("quantity")
    private Integer quantity;

    @NotNull(message = "El precio de venta es requerido")
    @JsonProperty("sale_price")
    private Double salePrice;

}
