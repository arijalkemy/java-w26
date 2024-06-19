package com.mercadolibre.pf_be_hisp_w26_t01_coro.util;

import com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos.*;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.entity.InboundOrder;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.entity.Section;

import java.util.ArrayList;
import java.util.List;

public class InboundOrderMapper {



    public static InboundOrderResponseDTO inboundOrderToResponseDto(InboundOrder inboundOrder){
        return InboundOrderResponseDTO.builder()
                                        .order_number(inboundOrder.getId())
                                        .order_date(inboundOrder.getOrderDate())
                                        .batch_stock(new ArrayList<>())
                                        .build();
    }

    public static InboundOrderResponseDTO inboundOrderToResponseDto
            (InboundOrder inboundOrder, List<BatchStockDTO> batchList){
        return InboundOrderResponseDTO.builder()
                .order_number(inboundOrder.getId())
                .order_date(inboundOrder.getOrderDate())
                .section(new SectionDTO(inboundOrder.getSection().getId(),inboundOrder.getSection().getWarehouse().getId()))
                .batch_stock(batchList)
                .build();
    }

    public static InboundOrder InboundOrderRequestDtoToInboundOrder(InboundOrderDto inboundOrderRequestDTO,
                                                                    Section section)

    {
        return InboundOrder.builder()
                        .id(inboundOrderRequestDTO.getOrderNumber())
                        .orderDate(inboundOrderRequestDTO.getOrderDate())
                        .section(section)
                        .batches(new ArrayList<>())
                        .build();
    }
}
