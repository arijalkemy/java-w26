package com.mercadolibre.pf_be_hisp_w26_t4_aquino.service;

import com.mercadolibre.pf_be_hisp_w26_t4_aquino.dtos.request.PurchaseOrderRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.dtos.response.ProductOrderDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.dtos.response.ProductOrderTotalDTO;

import java.util.List;

public interface IProductOrderService {
    List<ProductOrderDTO> getAllByPurchaseOrderId(Long purchaseOrderId);
    List<ProductOrderDTO> updateOrder(Long idOrder, PurchaseOrderRequestDTO status);
    ProductOrderTotalDTO saveOrder(PurchaseOrderRequestDTO purchaseOrderDTO);
}
