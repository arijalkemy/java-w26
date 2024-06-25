package com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.batch;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.stock.StockResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BatchStockResponseDTO {

    @JsonProperty("batch_stock")
    private List<StockResponseDTO> batchStock;

}
