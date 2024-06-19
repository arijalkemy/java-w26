package com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchListProductDTO {
    private SectorDTO section;
    private Integer product_id;
    private List<BatchStockDTO> batch_stock;

}
