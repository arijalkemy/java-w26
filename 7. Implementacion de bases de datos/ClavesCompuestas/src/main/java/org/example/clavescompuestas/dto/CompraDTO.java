package org.example.clavescompuestas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraDTO{
    private Long clienteId;
    private LocalDate fecha;
    private Double valor;
    private String ciudad;
    private String observacion;
    private Integer numeroTienda;
    private String tipoPago;
}
