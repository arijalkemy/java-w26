package com.mercadolibre.pf_be_hisp_w26_t01_coro.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos.*;

import java.util.List;

public interface IInboundOrdenService {

    BatchStockResponseDTO create(InboundOrderDto inboundOrderRequestDTO, String emailUser);
    BatchStockResponseDTO update(InboundOrderDto inboundOrderRequestDTO, String emailUser);
}
