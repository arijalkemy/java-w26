package com.mercadolibre.pf_be_hisp_w26_t01_arguello.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.*;

import java.util.List;

public interface IInboundOrderService {

    BatchStockResponseDTO create(InboundOrderDto inboundOrderRequestDTO, String emailUser);
    BatchStockResponseDTO update(InboundOrderDto inboundOrderRequestDTO, String emailUser);
    List<InboundOrderResponseDTO> getAllByIdWarehouse(int idWarehouse, String emailUser);
    InboundOrderResponseDTO getById(int idOrder, String emailUser);
}
