package com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.service;

import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos.order.PurchaseOrderRequestBodyDto;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos.order.PurchaseOrderResponseDto;

public interface IShoppingCartService {
    public PurchaseOrderResponseDto modifyPurchaseOrder(Integer orderId, PurchaseOrderRequestBodyDto purchaseOrder);
}
