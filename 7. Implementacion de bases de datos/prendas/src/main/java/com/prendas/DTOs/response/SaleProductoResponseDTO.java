package com.prendas.DTOs.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleProductoResponseDTO {
    private Long id;
    @JsonProperty("venta_id")
    private Long ventaId;
    @JsonProperty("prenda_id")
    private Long prendaId;
    private Integer cantidad;
    @JsonProperty("precio_unitario")
    private Double precioUnitario;
}
