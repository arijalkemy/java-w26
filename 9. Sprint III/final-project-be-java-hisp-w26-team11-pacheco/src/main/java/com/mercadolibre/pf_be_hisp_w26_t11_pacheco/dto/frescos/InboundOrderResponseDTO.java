package com.mercadolibre.pf_be_hisp_w26_t11_pacheco.dto.frescos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InboundOrderResponseDTO {
    @JsonProperty("batch_stock")
    private List<BatchStockResponseDTO> batchStock;
}