package com.mercadolibre.pf_be_hisp_w26_t1_cassini.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos.*;

public interface IInboundOrdenService {

    BatchStockResponseDTO create(InboundOrderDto inboundOrderRequestDTO, String emailUser);
    BatchStockResponseDTO update(InboundOrderDto inboundOrderRequestDTO, String emailUser);
}
