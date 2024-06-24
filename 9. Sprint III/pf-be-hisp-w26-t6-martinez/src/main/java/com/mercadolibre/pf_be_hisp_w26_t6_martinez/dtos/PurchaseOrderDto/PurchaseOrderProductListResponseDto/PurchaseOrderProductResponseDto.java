package com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.PurchaseOrderDto.PurchaseOrderProductListResponseDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderProductResponseDto implements Serializable {
    @JsonProperty("product_id")
    private Long productId;
    private String name;
    private Integer quantity;
}
