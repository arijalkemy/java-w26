package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WarehouseProductQuantityDTO {
    @JsonProperty("warehouse_code")
    private Long id;
    @JsonProperty("total_quantity")
    private Integer totalQuantity;
}
