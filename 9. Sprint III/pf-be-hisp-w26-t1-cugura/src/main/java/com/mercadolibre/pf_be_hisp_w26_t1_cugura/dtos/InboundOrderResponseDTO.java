package com.mercadolibre.pf_be_hisp_w26_t1_cugura.dtos;

import java.time.LocalDate;
import java.util.List;

import lombok.*;

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
