package com.mercadolibre.pf_be_hisp_w26_t01_moises.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.ProductPurchaseResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.PurchaseOrderDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.PurchaseOrderResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.PurchaseTotalPriceDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.enums.PurchaseOrderSortingType;

import java.util.List;
import java.util.Optional;

public interface IPurchaseOrderService {
    PurchaseTotalPriceDTO calculatePurchaseTotalPrice(PurchaseOrderDTO purchaseOrderDTO);

    List<ProductPurchaseResponseDto> searchAllProductsByOrder(Integer idOrder);

    void modifyOrder(Integer id, PurchaseOrderDTO orderDTO);

    List<PurchaseOrderResponseDTO> getAllByBuyerEmailSorted(String buyerEmail,
                                                            Optional<PurchaseOrderSortingType> sortingType);
}
