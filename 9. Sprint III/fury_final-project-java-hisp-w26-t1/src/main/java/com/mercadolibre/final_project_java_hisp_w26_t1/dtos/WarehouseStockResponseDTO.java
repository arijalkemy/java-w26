package com.mercadolibre.final_project_java_hisp_w26_t1.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseStockResponseDTO {
    private Integer product_id;
    private List<WarehouseResponseDTO> warehouses;
}
