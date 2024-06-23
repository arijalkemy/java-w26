package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.request.PurchaseOrderRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.response.ProductOfPurchaseOrderResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.response.PurchaseOrderCreatedResponseDTO;

import java.util.List;

public interface IPurchaseOrderService {
    public PurchaseOrderCreatedResponseDTO upsertPurchaseOrder(PurchaseOrderRequestDTO purchaseOrderDTO, Integer idOrder);
    public List<ProductOfPurchaseOrderResponseDTO> getProductsOfPurchaseOrder(Integer idOrder);
}
