package com.showroom.showroom.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class SaleResponseDto {
    private LocalDate date;
    private double totalPrice;
    private String paymentMethod;
}
