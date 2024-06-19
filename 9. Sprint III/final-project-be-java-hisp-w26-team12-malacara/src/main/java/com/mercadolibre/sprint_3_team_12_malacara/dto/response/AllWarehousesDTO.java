package com.mercadolibre.sprint_3_team_12_malacara.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class AllWarehousesDTO {

    @JsonProperty("product_id")
    private Integer idProduct;
    @JsonProperty("warehouses")
    private List<WarehouseDTO> warehousesDTO;

}
