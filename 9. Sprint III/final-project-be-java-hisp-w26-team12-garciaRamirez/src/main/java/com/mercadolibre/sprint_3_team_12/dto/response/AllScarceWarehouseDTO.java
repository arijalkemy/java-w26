package com.mercadolibre.sprint_3_team_12.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class AllScarceWarehouseDTO {

    @JsonProperty("warehouses")
    private List<ScarceWarehouseDTO> warehouses;
}
