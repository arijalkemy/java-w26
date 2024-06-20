package com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.warehouse;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseInfoDto {

    @NotBlank(message = "Name of the warehouse is required")
    @JsonProperty("warehouse_name")
    String warehouseName;

    @NotBlank(message = "Supervisor id is required")
    @JsonProperty("supervisor_id")
    Long supervisorId;
}
