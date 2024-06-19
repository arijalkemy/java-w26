package com.mercadolibre.pf_be_hisp_w26_t11_arriaga.service;


import com.mercadolibre.pf_be_hisp_w26_t11_arriaga.dto.frescos.*;

import java.util.List;
import java.util.Optional;

public interface IMeliFrescosService {

    InboundOrderResponseDTO createInboundOrder(InboundOrderRequestDTO inboundOrderRequestDTO);

    InboundOrderResponseDTO updateInboundOrder(InboundOrderRequestDTO inboundOrderRequestDTO);

    List<ProductSimpleResponseDTO> listProducts(Optional<String> acronym);

    PurchaseResponseDTO registerPurchaseOrder(PurchaseRequestDTO purchaseRequestDTO);

    PurchaseResponseDTO updatePurchaseOrder(PurchaseRequestDTO purchaseRequestDTO);

    List<ProductSimpleResponseDTO> listProductsFromOrder(Integer idOrder);

    ProductBatchesResponseDTO listBatchesOfProduct(Integer idProduct, Optional<String> order);

    ProductWarehouseResponseDTO listProductStockByWarehouse(Integer idProduct);

    BatchSearchStockResponseDTO listOrderedDueDateProducts(Integer period, Optional<String> productTypeAcronym, Optional<String> order);

    List<BatchStockInboundOrderResponseDto> getInboudOrder(Integer inboundorderId);

    RepresentativeResponseDTO getRepresentativeByCodeWarehouse(Integer warehouseId);
}