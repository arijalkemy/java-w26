package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WarehouseProductStockDTO {
    @JsonProperty("product_id")
    private Long productId;
    @JsonProperty("warehouse")
    private List<WarehouseProductQuantityDTO> warehouseProductQuantity;
}
