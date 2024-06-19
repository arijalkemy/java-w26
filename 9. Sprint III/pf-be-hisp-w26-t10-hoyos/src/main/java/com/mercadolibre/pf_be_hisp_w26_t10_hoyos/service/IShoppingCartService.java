package com.mercadolibre.pf_be_hisp_w26_t10_hoyos.service;


import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.dtos.order.PurchaseOrderRequestBodyDto;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.dtos.order.PurchaseOrderResponseDto;

public interface IShoppingCartService {
    public PurchaseOrderResponseDto modifyPurchaseOrder(Integer orderId, PurchaseOrderRequestBodyDto purchaseOrder);
}
