package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOfPurchaseOrderResponseDTO {
    ProductDetailResponseDto product;
    Integer quantity;
}
