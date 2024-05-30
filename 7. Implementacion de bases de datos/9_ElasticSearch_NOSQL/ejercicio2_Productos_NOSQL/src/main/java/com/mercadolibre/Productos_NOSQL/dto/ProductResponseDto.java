package com.mercadolibre.Productos_NOSQL.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponseDto {
    String id;
    String name;
    String type;
    Double price_sale;
    Double price_cost;
    Integer cant_disp;
}
