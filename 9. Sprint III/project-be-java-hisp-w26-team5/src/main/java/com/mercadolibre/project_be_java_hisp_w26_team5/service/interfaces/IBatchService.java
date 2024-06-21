package com.mercadolibre.project_be_java_hisp_w26_team5.service.interfaces;

import com.mercadolibre.project_be_java_hisp_w26_team5.dto.request.InboundOrderRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.response.BatchResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.response.BatchStockDTO;
import org.springframework.stereotype.Service;

@Service
public interface IBatchService {
    public BatchResponseDTO createInboundOrder(InboundOrderRequestDTO inboundOrderRequestDTO);
    public BatchResponseDTO updateInboundOrder(InboundOrderRequestDTO inboundOrderRequestDTO);
    BatchStockDTO getBatchStockByProductId(Integer cantDays, Integer managerId, String category, String order);
}
