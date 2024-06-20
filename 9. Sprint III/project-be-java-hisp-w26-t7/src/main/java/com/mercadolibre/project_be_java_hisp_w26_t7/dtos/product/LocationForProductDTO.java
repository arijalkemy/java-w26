package com.mercadolibre.project_be_java_hisp_w26_t7.dtos.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.batch.BSResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.warehouse.SectionResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationForProductDTO {
    @JsonProperty("section")
    private SectionResponseDTO section;

    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("batch_stock")
    private List<BSResponseDTO> batchStock;
}
