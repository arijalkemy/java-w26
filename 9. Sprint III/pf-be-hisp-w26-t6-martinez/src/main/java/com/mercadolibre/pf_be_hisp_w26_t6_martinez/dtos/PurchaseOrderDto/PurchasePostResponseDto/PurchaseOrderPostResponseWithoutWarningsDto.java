package com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.PurchaseOrderDto.PurchasePostResponseDto;

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
