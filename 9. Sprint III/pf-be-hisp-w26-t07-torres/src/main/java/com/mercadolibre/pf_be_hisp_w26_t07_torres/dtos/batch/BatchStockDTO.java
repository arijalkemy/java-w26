package com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.batch;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BatchStockDTO {
    @JsonProperty("batch_id")
    private Long batchId;
    @JsonProperty("product_id")
    private Long productId;
    @JsonProperty("current_quantity")
    private Integer currentQuantity;
    @JsonProperty("threshold_quantity")
    private Integer thresholdQuantity;
}
