package com.mercadolibre.final_project_java_hisp_w26_t6.dtos.PurchaseOrderDto.PurchasePostResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderPostResponseWithoutWarningsDto implements Serializable, PurchaseOrderPostResponseDto {
    private Double totalPrice;
}
