package com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InboundOrderResponseDTO {
    Integer order_number;
    LocalDate order_date;
    SectionDTO section;
    List<BatchStockDTO> batch_stock;
}
