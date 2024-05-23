package com.prendas.DTOs.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleResponseDTO {
    private Long number;
    private LocalDate fecha;
    private Double total;
    @JsonProperty("medio_de_pago")
    private String medioDePago;
    @JsonProperty("lista_de_prendas")
    private List<SaleProductoResponseDTO> listaDePrendas;
}
