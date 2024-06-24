package com.mercadolibre.final_project_java_hisp_w26_t6.services.purchaseOrder;

import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.PurchaseOrderDto.PurchaseOrderInsertRequestDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.PurchaseOrderDto.PurchaseOrderProductListResponseDto.PurchaseOrderProductsResponseDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.PurchaseOrderDto.PurchasePostResponseDto.PurchaseOrderPostResponseDto;

public interface IPurchaseOrderService {

    PurchaseOrderPostResponseDto addPurchaseOrder(PurchaseOrderInsertRequestDto order );

    PurchaseOrderProductsResponseDto getPurchaseOrderProducts(Long idOrder);

    PurchaseOrderPostResponseDto updatePurchaseOrder(PurchaseOrderInsertRequestDto order, Long idOrder);
}
