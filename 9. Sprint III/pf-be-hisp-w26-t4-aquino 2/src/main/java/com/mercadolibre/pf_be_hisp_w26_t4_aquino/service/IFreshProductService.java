package com.mercadolibre.pf_be_hisp_w26_t4_aquino.service;

import com.mercadolibre.pf_be_hisp_w26_t4_aquino.dtos.BatchDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.dtos.request.InboundOrderRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.dtos.response.ProductLocationDto;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.model.User;

import com.mercadolibre.pf_be_hisp_w26_t4_aquino.util.BatchOrder;
import java.util.List;

public interface IFreshProductService {
    List<BatchDTO> addInboundOrder(InboundOrderRequestDTO inboundOrderDTO, User user) throws Exception;
    List<BatchDTO> updateInboundOrder(InboundOrderRequestDTO inboundOrderDTO, User user) throws Exception;
    List<ProductLocationDto> getProductLocationsOrderByBatch(User user, Long productId);
    List<ProductLocationDto> getProductLocationsByType(User user, BatchOrder order, Long idProduct);
}
