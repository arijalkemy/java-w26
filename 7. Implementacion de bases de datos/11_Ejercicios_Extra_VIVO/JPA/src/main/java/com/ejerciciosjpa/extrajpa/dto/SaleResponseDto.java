package com.ejerciciosjpa.extrajpa.dto;

import com.ejerciciosjpa.extrajpa.entities.Cloth;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleResponseDto {
    private Long numero;
    private LocalDate fecha;
    private Double total;
    private String medioDePago;
    private List<Cloth> clothes;
}
