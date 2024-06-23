package com.mercadolibre.project_be_java_hisp_w26_team5.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductLocationByIdDTO {
    private SectionProductByBatchDTO section;
    @JsonProperty("product_id")
    private int productId;
    @JsonProperty("batch_stock")
    private List<BatchStockProductByBatchDTO> batchStock;
}