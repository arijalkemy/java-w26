package com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.SectionDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.BatchDto.BatchStockDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListProductsBatchDto implements Serializable {

    private SectionDto section;

    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("batch_stock")
    private List<BatchStockDto> batchStock;
}
