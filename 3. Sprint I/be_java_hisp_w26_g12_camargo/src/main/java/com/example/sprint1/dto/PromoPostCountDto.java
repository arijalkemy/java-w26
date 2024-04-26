package com.example.sprint1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostCountDto {
    private Integer userId;
    private String userName;
    private Integer promoProductsCount;
}
