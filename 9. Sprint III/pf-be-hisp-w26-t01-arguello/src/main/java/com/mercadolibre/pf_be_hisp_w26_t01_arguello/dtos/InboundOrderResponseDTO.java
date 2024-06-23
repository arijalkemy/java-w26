package com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InboundOrderResponseDTO {
    Integer order_number;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonSerialize(using = LocalDateSerializer.class)
    LocalDate order_date;
    SectionDTO section;
    List<BatchStockDTO> batch_stock;
}
