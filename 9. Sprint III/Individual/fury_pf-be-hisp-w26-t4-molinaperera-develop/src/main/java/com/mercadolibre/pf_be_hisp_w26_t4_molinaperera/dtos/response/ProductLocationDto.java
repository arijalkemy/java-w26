package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

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
