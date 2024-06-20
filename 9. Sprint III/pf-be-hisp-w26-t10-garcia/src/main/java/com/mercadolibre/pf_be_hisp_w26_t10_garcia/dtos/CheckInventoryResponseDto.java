package com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckInventoryResponseDto {
    private Integer product_id;
    private List<InventoryByWarehouseDto> warehauses;
}
