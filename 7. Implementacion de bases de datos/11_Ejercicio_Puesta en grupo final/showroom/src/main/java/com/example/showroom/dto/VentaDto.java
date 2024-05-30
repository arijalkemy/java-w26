package com.example.showroom.dto;

import com.example.showroom.entity.Prenda;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaDto {
    private LocalDate fecha;
    private Double total;
    private String medio_pago;
    private List<Prenda> prendas;
}
