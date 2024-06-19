package com.mercadolibre.project_be_java_hisp_w26_t7.dtos.order;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.errors.SimpleProductErrorDto;
import com.mercadolibre.project_be_java_hisp_w26_t7.entity.OrderProductSeller;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductPurchaseOrderCheckDTO {
    private List<OrderProductSeller> orderProductSellerList;
    private List<SimpleProductErrorDto> responseErrorList;
    private double orderTotal;
}
