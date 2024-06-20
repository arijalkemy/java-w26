package com.mercadolibre.fresh_market.service;

import com.mercadolibre.fresh_market.dtos.BatchDTO;
import com.mercadolibre.fresh_market.dtos.InboundOrderDTO;

import java.util.List;

public interface IInboundOrder {
    List<BatchDTO> createInboundOrder(InboundOrderDTO inboundOrderDTO);
    List<BatchDTO> updateInboundOrder(Long id, InboundOrderDTO inboundOrderDTO);
}
