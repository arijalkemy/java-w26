package com.mercadolibre.pf_be_hisp_w26_t1_cugura.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t1_cugura.dtos.ProductPurchaseResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.dtos.PurchaseOrderDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.dtos.PurchaseTotalPriceDTO;

import java.util.List;

public interface IPurchaseOrderService {
    PurchaseTotalPriceDTO calculatePurchaseTotalPrice(PurchaseOrderDTO purchaseOrderDTO);
    List<ProductPurchaseResponseDto> searchAllProductsByOrder(Integer idOrder);
    void modifyOrder(Integer id,PurchaseOrderDTO orderDTO);
}
