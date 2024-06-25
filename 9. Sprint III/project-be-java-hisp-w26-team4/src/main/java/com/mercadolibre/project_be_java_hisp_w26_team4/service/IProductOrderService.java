package com.mercadolibre.project_be_java_hisp_w26_team4.service;

import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.request.PurchaseOrderRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.response.ProductOrderDTO;
import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.response.ProductOrderTotalDTO;

import java.util.List;

public interface IProductOrderService {
    List<ProductOrderDTO> getAllByPurchaseOrderId(Long purchaseOrderId);
    List<ProductOrderDTO> updateOrder(Long idOrder, PurchaseOrderRequestDTO status);
    ProductOrderTotalDTO saveOrder(PurchaseOrderRequestDTO purchaseOrderDTO);
}
