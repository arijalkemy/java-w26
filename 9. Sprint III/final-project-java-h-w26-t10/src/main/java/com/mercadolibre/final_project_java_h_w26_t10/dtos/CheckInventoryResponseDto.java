package com.mercadolibre.final_project_java_h_w26_t10.dtos;

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
