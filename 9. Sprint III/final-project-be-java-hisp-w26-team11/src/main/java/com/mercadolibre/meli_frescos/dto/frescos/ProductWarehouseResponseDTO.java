package com.mercadolibre.meli_frescos.dto.frescos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProductWarehouseResponseDTO {
    private Integer productId;
    private List<WarehouseDTO> warehouses;
}
