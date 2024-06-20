package com.mercadolibre.pf_be_hisp_w26_t11_perez.dto.frescos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PurchaseOrderDetailDTO {
    private Integer orderId;
    private Double totalCost;
    private String orderStatus;
    private String date;
    private Integer buyerId;
    List<ProductDetailDTO> products;
}
