package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.order;

import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.errors.SimpleProductErrorDto;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.entity.OrderProductSeller;
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
