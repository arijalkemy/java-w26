package com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos;

import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.entity.Batch;
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
