package com.mercadolibre.fresh_market.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WarehouseProduct {

    Long warehouseId;
    int quantity;
}
