package com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.PurchaseOrderDto.PurchaseOrderProductListResponseDto;

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
public class PurchaseOrderProductsResponseDto implements Serializable {
    List<PurchaseOrderProductResponseDto> products;
}
