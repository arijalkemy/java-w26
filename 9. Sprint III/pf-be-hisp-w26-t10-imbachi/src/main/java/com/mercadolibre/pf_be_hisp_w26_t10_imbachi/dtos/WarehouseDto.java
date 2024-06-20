package com.mercadolibre.pf_be_hisp_w26_t10_imbachi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseDto {
    private Integer warehouse_id;
    private String name;
}
