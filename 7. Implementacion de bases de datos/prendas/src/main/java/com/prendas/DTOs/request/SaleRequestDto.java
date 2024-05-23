package com.prendas.DTOs.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class SaleRequestDto {
    private LocalDate fecha;
    private Double total;
    private String medioDePago;
    @JsonProperty("lista_de_prendas")
    List<SaleProductoRequestDTO> listaDePrendas = new ArrayList<>();
}
