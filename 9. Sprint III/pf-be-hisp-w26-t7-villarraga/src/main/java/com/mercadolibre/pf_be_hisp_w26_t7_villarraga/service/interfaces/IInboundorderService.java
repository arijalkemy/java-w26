package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.service.interfaces;


import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.batch.BatchStockResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.others.InboundorderRequestDTO;

public interface IInboundorderService {
    BatchStockResponseDTO saveInboundorder(InboundorderRequestDTO inboundOrderRequestDTO);

    BatchStockResponseDTO updateInboundorder(InboundorderRequestDTO inboundOrderRequestDTO);

    void deleteBatchByNumberAndProduct(Long batchNumber, Long productId);
}
