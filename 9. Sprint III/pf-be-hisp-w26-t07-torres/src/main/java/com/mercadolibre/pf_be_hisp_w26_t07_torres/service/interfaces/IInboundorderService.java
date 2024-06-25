package com.mercadolibre.pf_be_hisp_w26_t07_torres.service.interfaces;


import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.batch.BatchStockResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.others.InboundorderRequestDTO;

public interface IInboundorderService {
    BatchStockResponseDTO saveInboundorder(InboundorderRequestDTO inboundOrderRequestDTO);

    BatchStockResponseDTO updateInboundorder(InboundorderRequestDTO inboundOrderRequestDTO);
}
