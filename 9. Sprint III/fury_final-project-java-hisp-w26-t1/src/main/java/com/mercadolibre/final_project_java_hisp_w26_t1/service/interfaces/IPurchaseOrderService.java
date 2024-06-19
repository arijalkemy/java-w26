package com.mercadolibre.final_project_java_hisp_w26_t1.service.interfaces;

import com.mercadolibre.final_project_java_hisp_w26_t1.dtos.ProductPurchaseResponseDto;
import com.mercadolibre.final_project_java_hisp_w26_t1.dtos.PurchaseOrderDTO;
import com.mercadolibre.final_project_java_hisp_w26_t1.dtos.PurchaseTotalPriceDTO;

import java.util.List;

public interface IPurchaseOrderService {
    PurchaseTotalPriceDTO calculatePurchaseTotalPrice(PurchaseOrderDTO purchaseOrderDTO);
    List<ProductPurchaseResponseDto> searchAllProductsByOrder(Integer idOrder);
    void modifyOrder(Integer id,PurchaseOrderDTO orderDTO);
}
