package com.prendas.DTOs.response;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.prendas.models.VentaPrenda;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
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
