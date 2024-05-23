package com.prendas.DTOs.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.prendas.models.Prenda;
import lombok.Data;

@Data
public class SaleProductoRequestDTO {
    @JsonProperty("prenda_id")
    private Long prendaId;
    private Integer cantidad;
    private Double precioUnitario;
}
