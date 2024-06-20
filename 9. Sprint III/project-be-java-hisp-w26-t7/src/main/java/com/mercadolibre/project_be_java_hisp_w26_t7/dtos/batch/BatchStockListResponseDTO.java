package com.mercadolibre.project_be_java_hisp_w26_t7.dtos.batch;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BatchStockListResponseDTO {

    @JsonProperty("batch_stock")
    private List<BatchStockDetailsResponseDTO> batchStock;

}
