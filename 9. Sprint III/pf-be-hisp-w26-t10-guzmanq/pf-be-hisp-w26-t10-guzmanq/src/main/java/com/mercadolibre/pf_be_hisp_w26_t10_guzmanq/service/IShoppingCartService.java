package com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.service;

import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.dtos.order.PurchaseOrderRequestBodyDto;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.dtos.order.PurchaseOrderResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.entity.ShoppingCart;

import java.util.List;

public interface IShoppingCartService {
    public PurchaseOrderResponseDto modifyPurchaseOrder(Integer orderId, PurchaseOrderRequestBodyDto purchaseOrder);
    //Double getTotalProductsSalesForMonth(Integer idWarehouse);
    //Double getTotalSalesForMonth(Integer idWarehouse);
}
