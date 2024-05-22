package com.example.showroomelastic.dto;

import com.example.showroomelastic.models.Clothe;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class SaleRequestDto {
    private String numero;
    private Long fecha;
    private Double total;
    private String medioDePago;
    private List<Clothe> prendas;
}
