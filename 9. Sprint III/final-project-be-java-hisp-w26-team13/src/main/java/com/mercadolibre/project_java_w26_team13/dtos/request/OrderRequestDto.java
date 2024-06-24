package com.mercadolibre.project_java_w26_team13.dtos.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {

    @JsonProperty("order_number")
    private int orderNumber;
    @JsonProperty("order_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate orderDate;
    private SectionDto section;
    @JsonProperty("batch_stock")
    private List<BatchStockDto> batch;
}
