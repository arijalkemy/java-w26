package com.mercadolibre.project_be_java_hisp_w26_team4.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductLocationDto {
    SectionDTO section;

    @JsonProperty("product_id")
    Long productId;

    @JsonProperty("batch_stock")
    List<BatchInfoDto> batches;
}
