package com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.warehouse;

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
