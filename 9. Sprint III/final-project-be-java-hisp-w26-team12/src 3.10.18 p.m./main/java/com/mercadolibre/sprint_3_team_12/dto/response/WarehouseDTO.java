package com.mercadolibre.sprint_3_team_12.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class WarehouseDTO {
    @JsonProperty("warehouse_code")
    private Integer warehouseCode;
    @JsonProperty("total_quantity")
    private Integer total;
}
