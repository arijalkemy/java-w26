package com.mercadolibre.meli_frescos.dto.frescos;

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
