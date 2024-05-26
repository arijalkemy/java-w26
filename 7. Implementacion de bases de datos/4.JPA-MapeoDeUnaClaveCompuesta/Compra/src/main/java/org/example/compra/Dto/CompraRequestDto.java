package org.example.compra.Dto;

import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CompraRequestDto {
    private Integer clienteId;
    private LocalDate fecha;
    private String medioPago;
    private double total;
}
