package com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.WarehouseDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductByWarehouseDto implements Serializable {

    @JsonProperty("product_id")
    private Long productId;

    private List<WarehouseQuantityDto> warehouses;
}
