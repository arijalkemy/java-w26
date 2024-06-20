package com.mercadolibre.pf_be_hisp_w26_t10_garcia.service;

import com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos.order.PurchaseOrderRequestBodyDto;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos.order.PurchaseOrderResponseDto;

public interface IShoppingCartService {
    public PurchaseOrderResponseDto modifyPurchaseOrder(Integer orderId, PurchaseOrderRequestBodyDto purchaseOrder);
}
