package com.mercadolibre.pf_be_hisp_w26_t01_ditta.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t01_ditta.dtos.*;

public interface IInboundOrdenService {

    BatchStockResponseDTO create(InboundOrderDto inboundOrderRequestDTO, String emailUser);
    BatchStockResponseDTO update(InboundOrderDto inboundOrderRequestDTO, String emailUser);
}
