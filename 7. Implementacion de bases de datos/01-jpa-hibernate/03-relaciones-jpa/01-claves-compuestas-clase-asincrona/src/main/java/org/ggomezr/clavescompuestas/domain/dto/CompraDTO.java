package org.ggomezr.clavescompuestas.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompraDTO {
    private Integer id;
    private Integer numCompra;
    private LocalDate fecha;
    private Double total;
    private String descripcion;
}
