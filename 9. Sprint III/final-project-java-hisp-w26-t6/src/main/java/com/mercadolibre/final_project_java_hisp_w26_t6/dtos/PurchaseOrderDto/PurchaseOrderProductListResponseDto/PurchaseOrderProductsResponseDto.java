package com.mercadolibre.final_project_java_hisp_w26_t6.dtos.PurchaseOrderDto.PurchaseOrderProductListResponseDto;

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
