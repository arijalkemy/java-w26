package com.mercadolibre.project_java_w26_team13.service;

import com.mercadolibre.project_java_w26_team13.dtos.request.BatchStockDto;
import com.mercadolibre.project_java_w26_team13.dtos.request.OrderRequestDto;
import com.mercadolibre.project_java_w26_team13.dtos.response.BatcheStockDTO;

import java.util.List;

public interface IOrderService {
    List<BatchStockDto> registerBatch(OrderRequestDto orderRequestDto, String authorizationHeader);
    BatcheStockDTO updateInboundOrder(OrderRequestDto orderRequestDto, String authorizationHeader);
}
