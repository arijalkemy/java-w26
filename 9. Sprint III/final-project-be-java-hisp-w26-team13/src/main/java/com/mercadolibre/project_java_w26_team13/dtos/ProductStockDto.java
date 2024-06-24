package com.mercadolibre.project_java_w26_team13.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductStockDto {

    @JsonProperty("product_id")
    private long productId;

    @JsonProperty("warehouses")
    private List<WarehouseProductDto> warehouseProductDtoList;
}
