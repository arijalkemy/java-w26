package com.mercadolibre.pf_be_hisp_w26_t6_martinez.mappers;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.entity.Batch;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.entity.InboundOrder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class InboundOrderMapper {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static InboundOrder createInboundOrder(Long orderNumber, String orderDate, List<Batch> batches) {
        LocalDate inboundOrderDate = LocalDate.parse(orderDate, formatter);

        return InboundOrder.builder()
                .orderNumber(orderNumber)
                .orderDate(inboundOrderDate)
                .batches(batches)
                .build();
    }
}
