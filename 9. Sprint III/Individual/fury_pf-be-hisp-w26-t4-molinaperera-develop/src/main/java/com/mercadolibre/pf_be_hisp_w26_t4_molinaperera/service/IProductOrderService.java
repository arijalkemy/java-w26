package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.service;

import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.request.PurchaseOrderRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.response.ProductOrderDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.response.ProductOrderTotalDTO;

import java.util.List;

public interface IProductOrderService {
    List<ProductOrderDTO> getAllByPurchaseOrderId(Long purchaseOrderId);
    List<ProductOrderDTO> updateOrder(Long idOrder, PurchaseOrderRequestDTO status);
    ProductOrderTotalDTO saveOrder(PurchaseOrderRequestDTO purchaseOrderDTO);
}
