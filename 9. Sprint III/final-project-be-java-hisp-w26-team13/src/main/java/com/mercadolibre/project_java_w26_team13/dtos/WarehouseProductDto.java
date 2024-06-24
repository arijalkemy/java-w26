package com.mercadolibre.project_java_w26_team13.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseProductDto {

    @JsonProperty("warehouse_code")
    private Integer warehouseCode;
    @JsonProperty("total_quantity")
    private Integer totalQuantity;
}
