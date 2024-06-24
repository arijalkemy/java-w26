package com.mercadolibre.project_java_w26_team13.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BatchesByProductDTO {
    @JsonProperty("section")
    private SectionDTO section;

    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("batch_stock")
    private List<MinimumBatchDTO> batchStock;

}
