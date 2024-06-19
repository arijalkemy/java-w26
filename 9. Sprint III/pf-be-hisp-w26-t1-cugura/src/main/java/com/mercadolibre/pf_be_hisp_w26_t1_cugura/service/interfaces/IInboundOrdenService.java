package com.mercadolibre.pf_be_hisp_w26_t1_cugura.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t1_cugura.dtos.*;

import java.util.List;

public interface IInboundOrdenService {

    BatchStockResponseDTO create(InboundOrderDto inboundOrderRequestDTO, String emailUser);
    BatchStockResponseDTO update(InboundOrderDto inboundOrderRequestDTO, String emailUser);
}
