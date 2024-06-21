package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.warehouse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockQuantityResponseDto {

    @JsonProperty("product_id")
    private Integer productId;

    @JsonProperty("warehouses")
    private List<WarehouseResponseDTO> warehouses;

}
