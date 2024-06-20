package com.mercadolibre.project_be_java_hisp_w26_t7.service.interfaces;


import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.others.TotalPriceResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.product.ProductResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.product.PurchaseOrderRequestDTO;

import java.util.List;

public interface IOrderService {
    TotalPriceResponseDTO saveProductList(PurchaseOrderRequestDTO purchaseOrderRequestDTO);

    List<ProductResponseDTO> findProductsByOrder(Long idOrder);

    TotalPriceResponseDTO updateProductList(Long idOrder, PurchaseOrderRequestDTO purchaseOrderRequestDTO);
}
