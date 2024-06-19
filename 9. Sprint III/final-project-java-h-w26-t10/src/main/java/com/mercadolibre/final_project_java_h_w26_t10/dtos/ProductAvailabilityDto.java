package com.mercadolibre.final_project_java_h_w26_t10.dtos;

import com.mercadolibre.final_project_java_h_w26_t10.entity.Batch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductAvailabilityDto {
    private Batch batch;
    private Integer productId;
    private Integer quantity;
}
