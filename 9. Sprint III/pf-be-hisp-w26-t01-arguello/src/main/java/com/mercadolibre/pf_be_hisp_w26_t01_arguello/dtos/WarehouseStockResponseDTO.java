package com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos;

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
