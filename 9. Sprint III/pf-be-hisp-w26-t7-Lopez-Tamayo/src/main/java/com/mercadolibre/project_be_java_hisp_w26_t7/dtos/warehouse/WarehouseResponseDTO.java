package com.mercadolibre.project_be_java_hisp_w26_t7.dtos.warehouse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseResponseDTO {

    @JsonProperty("warehouse_code")
    private Integer warehouseCode;

    @JsonProperty("total_quantity")
    private Integer totalQuantity;

}
