package com.mercadolibre.final_project_java_h_w26_t10.service;

import com.mercadolibre.final_project_java_h_w26_t10.dtos.order.PurchaseOrderRequestBodyDto;
import com.mercadolibre.final_project_java_h_w26_t10.dtos.order.PurchaseOrderResponseDto;

public interface IShoppingCartService {
    public PurchaseOrderResponseDto modifyPurchaseOrder(Integer orderId, PurchaseOrderRequestBodyDto purchaseOrder);
}
