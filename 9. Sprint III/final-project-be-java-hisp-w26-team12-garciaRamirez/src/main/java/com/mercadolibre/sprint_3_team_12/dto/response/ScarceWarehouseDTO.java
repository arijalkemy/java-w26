package com.mercadolibre.sprint_3_team_12.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.sprint_3_team_12.dto.request.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ScarceWarehouseDTO {

    @JsonProperty("warehouse_code")
    private Long warehouseCode;

    @JsonProperty("products")
    private List<ProductDTO> products;
}
