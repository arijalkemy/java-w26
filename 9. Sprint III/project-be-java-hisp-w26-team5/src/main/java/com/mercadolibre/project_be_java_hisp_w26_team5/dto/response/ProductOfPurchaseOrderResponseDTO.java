package com.mercadolibre.project_be_java_hisp_w26_team5.dto.response;

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
