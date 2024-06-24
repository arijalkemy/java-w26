package com.mercadolibre.pf_be_hisp_w26_t6_martinez.services.purchaseOrder;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.PurchaseOrderDto.PurchaseOrderInsertRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.PurchaseOrderDto.PurchaseOrderProductListResponseDto.PurchaseOrderProductsResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.PurchaseOrderDto.PurchasePostResponseDto.PurchaseOrderPostResponseDto;

public interface IPurchaseOrderService {

    PurchaseOrderPostResponseDto addPurchaseOrder(PurchaseOrderInsertRequestDto order );

    PurchaseOrderProductsResponseDto getPurchaseOrderProducts(Long idOrder);

    PurchaseOrderPostResponseDto updatePurchaseOrder(PurchaseOrderInsertRequestDto order, Long idOrder);
}
