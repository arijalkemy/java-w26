package com.mercadolibre.fresh_market.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductStockDTO {
    Long productId;
    List<WarehouseProduct> warehouseProducts;
}
