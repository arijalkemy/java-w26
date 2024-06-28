package com.mercadolibre.project_be_java_hisp_w26_t7.service.interfaces;


import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.batch.BatchStockResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.others.InboundorderRequestDTO;

public interface IInboundorderService {
    BatchStockResponseDTO saveInboundorder(InboundorderRequestDTO inboundOrderRequestDTO);

    BatchStockResponseDTO updateInboundorder(InboundorderRequestDTO inboundOrderRequestDTO);
}
