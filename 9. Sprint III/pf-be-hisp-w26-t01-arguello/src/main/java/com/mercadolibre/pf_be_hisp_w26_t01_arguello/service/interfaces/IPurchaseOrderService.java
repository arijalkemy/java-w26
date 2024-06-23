package com.mercadolibre.pf_be_hisp_w26_t01_arguello.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.ProductPurchaseResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.PurchaseOrderDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.PurchaseTotalPriceDTO;

import java.util.List;

public interface IPurchaseOrderService {
    PurchaseTotalPriceDTO calculatePurchaseTotalPrice(PurchaseOrderDTO purchaseOrderDTO);
    List<ProductPurchaseResponseDto> searchAllProductsByOrder(Integer idOrder);
    void modifyOrder(Integer id,PurchaseOrderDTO orderDTO);
}
