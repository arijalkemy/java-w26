package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.request.InboundOrderRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.response.BatchResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.response.BatchStockDTO;
import org.springframework.stereotype.Service;

@Service
public interface IBatchService {
    public BatchResponseDTO createInboundOrder(InboundOrderRequestDTO inboundOrderRequestDTO);
    public BatchResponseDTO updateInboundOrder(InboundOrderRequestDTO inboundOrderRequestDTO);
    BatchStockDTO getBatchStockByProductId(Integer cantDays, Integer managerId, String category, String order);
}
