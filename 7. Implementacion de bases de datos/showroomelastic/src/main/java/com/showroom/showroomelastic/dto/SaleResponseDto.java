package com.showroom.showroomelastic.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class SaleResponseDto {
    private LocalDate date;
    private double totalPrice;
    private String paymentMethod;
}
