package com.mercadolibre.pf_be_hisp_w26_t01_arguello.util;

import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.*;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.entity.InboundOrder;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.entity.Section;

import java.util.ArrayList;
import java.util.List;

public class InboundOrderMapper {

    public static InboundOrderResponseDTO inboundOrderToResponseDto
            (InboundOrder inboundOrder){
        InboundOrderResponseDTO  inboundOrderResponseDTO = new InboundOrderResponseDTO();
        inboundOrderResponseDTO.setOrder_number(inboundOrder.getId());
        inboundOrderResponseDTO.setOrder_date(inboundOrder.getOrderDate());
        inboundOrderResponseDTO.setSection(new SectionDTO(inboundOrder.getSection().getId(),
                                            inboundOrder.getSection().getWarehouse().getId()));
        if(inboundOrder.getBatches() != null){

            inboundOrderResponseDTO.setBatch_stock(inboundOrder.getBatches().stream()
                    .map(BatchMapper::toBatchStockDTO).toList());
        }
        return inboundOrderResponseDTO;
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
