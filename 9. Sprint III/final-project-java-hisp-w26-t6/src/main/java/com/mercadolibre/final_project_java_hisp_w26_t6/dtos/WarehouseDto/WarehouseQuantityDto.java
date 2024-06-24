package com.mercadolibre.final_project_java_hisp_w26_t6.dtos.WarehouseDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class WarehouseQuantityDto implements Serializable {
    @JsonProperty("warehouse_code")
    private Integer warehouseCode;

    @JsonProperty("total_quantity")
    private Integer totalQuantity;
}
