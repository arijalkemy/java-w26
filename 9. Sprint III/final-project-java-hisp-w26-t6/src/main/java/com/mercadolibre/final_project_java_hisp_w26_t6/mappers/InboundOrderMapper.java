package com.mercadolibre.final_project_java_hisp_w26_t6.mappers;

import com.mercadolibre.final_project_java_hisp_w26_t6.entity.Batch;
import com.mercadolibre.final_project_java_hisp_w26_t6.entity.InboundOrder;

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
