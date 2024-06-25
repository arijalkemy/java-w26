package com.mercadolibre.project_be_java_hisp_w26_team4.service;

import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.BatchDTO;
import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.request.InboundOrderRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.response.ProductLocationDto;
import com.mercadolibre.project_be_java_hisp_w26_team4.model.User;

import com.mercadolibre.project_be_java_hisp_w26_team4.util.BatchOrder;
import java.util.List;

public interface IFreshProductService {
    List<BatchDTO> addInboundOrder(InboundOrderRequestDTO inboundOrderDTO, User user) throws Exception;
    List<BatchDTO> updateInboundOrder(InboundOrderRequestDTO inboundOrderDTO, User user) throws Exception;
    List<ProductLocationDto> getProductLocationsOrderByBatch(User user, Long productId);
    List<ProductLocationDto> getProductLocationsByType(User user, BatchOrder order, Long idProduct);
}
