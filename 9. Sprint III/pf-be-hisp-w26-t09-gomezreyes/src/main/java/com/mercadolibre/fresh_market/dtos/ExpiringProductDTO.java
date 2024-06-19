package com.mercadolibre.fresh_market.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpiringProductDTO {
    private Integer batchNumber;
    private Long productId;
    private Integer productTypeId;
    private LocalDate dueDate;
    private Integer currentQuantity;
}
