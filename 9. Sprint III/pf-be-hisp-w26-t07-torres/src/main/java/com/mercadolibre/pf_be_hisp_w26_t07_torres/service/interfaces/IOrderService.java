package com.mercadolibre.pf_be_hisp_w26_t07_torres.service.interfaces;


import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.others.TotalPriceResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.product.ProductResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.product.PurchaseOrderRequestDTO;

import java.util.List;

public interface IOrderService {
    TotalPriceResponseDTO saveProductList(PurchaseOrderRequestDTO purchaseOrderRequestDTO);

    List<ProductResponseDTO> findProductsByOrder(Long idOrder);

    TotalPriceResponseDTO updateProductList(Long idOrder, PurchaseOrderRequestDTO purchaseOrderRequestDTO);
}
