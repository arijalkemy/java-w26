package com.mercadolibre.fresh_market.service;

import com.mercadolibre.fresh_market.dtos.BatchDTO;
import com.mercadolibre.fresh_market.dtos.InboundOrderDTO;
import com.mercadolibre.fresh_market.dtos.InboundOrderReqDTO;

import java.util.List;

public interface IInboundOrderService {
    List<BatchDTO> createInboundOrder(InboundOrderReqDTO inboundOrderReqDTO);
    List<BatchDTO> updateInboundOrder(Long id, InboundOrderReqDTO inboundOrderReqDTO);
}
