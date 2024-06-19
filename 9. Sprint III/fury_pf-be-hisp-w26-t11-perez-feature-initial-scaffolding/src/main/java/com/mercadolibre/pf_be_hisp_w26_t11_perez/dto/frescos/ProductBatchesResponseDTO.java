package com.mercadolibre.pf_be_hisp_w26_t11_perez.dto.frescos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ProductBatchesResponseDTO {
    private SectionDTO section;
    private Integer productId;
    @JsonProperty("batch_stock")
    private List<BatchDTO> batches;
}
