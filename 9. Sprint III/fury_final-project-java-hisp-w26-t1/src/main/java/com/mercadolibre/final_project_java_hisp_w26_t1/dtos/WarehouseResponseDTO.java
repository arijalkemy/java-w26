package com.mercadolibre.final_project_java_hisp_w26_t1.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseResponseDTO {
    private Integer warehouse_code;
    private Integer total_quantity;
}
