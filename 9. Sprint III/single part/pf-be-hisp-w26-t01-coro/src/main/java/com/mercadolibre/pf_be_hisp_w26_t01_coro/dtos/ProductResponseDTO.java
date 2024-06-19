package com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class ProductResponseDTO {
    private String name;
    private Double price;
    private String category;
}
