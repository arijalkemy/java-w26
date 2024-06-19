package com.mercadolibre.pf_be_hisp_w26_t11_roman.dto.frescos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProductWarehouseResponseDTO {
    private Integer productId;
    private List<WarehouseDTO> warehouses;
}
