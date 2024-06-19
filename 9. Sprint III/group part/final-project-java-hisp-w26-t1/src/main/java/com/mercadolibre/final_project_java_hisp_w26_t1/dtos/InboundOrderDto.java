package com.mercadolibre.final_project_java_hisp_w26_t1.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class InboundOrderDto {
    @JsonProperty("order_number")
    Integer orderNumber;
    @JsonProperty("order_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate orderDate;
    SectionDTO section;
    @JsonProperty("batch_stock")
    List<BatchStockDTO> batchStock;
}
