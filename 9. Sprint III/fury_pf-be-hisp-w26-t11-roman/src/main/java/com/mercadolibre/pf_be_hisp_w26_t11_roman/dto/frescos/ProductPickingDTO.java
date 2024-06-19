package com.mercadolibre.pf_be_hisp_w26_t11_roman.dto.frescos;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductPickingDTO {
    private Integer productId;
    private Integer requestedQuantity;
    private List<BatchPickingDTO> batches;
}
