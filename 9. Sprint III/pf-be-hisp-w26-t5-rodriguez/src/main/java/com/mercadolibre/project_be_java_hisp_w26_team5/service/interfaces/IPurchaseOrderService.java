package com.mercadolibre.project_be_java_hisp_w26_team5.service.interfaces;

import com.mercadolibre.project_be_java_hisp_w26_team5.dto.request.PurchaseOrderRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.response.ProductOfPurchaseOrderResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.response.PurchaseOrderCreatedResponseDTO;

import java.util.List;

public interface IPurchaseOrderService {
    public PurchaseOrderCreatedResponseDTO upsertPurchaseOrder(PurchaseOrderRequestDTO purchaseOrderDTO, Integer idOrder);
    public List<ProductOfPurchaseOrderResponseDTO> getProductsOfPurchaseOrder(Integer idOrder);
}
