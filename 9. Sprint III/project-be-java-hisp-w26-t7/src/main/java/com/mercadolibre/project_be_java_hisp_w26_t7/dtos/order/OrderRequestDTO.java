package com.mercadolibre.project_be_java_hisp_w26_t7.dtos.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.batch.BatchStockRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.warehouse.SectionRequestDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDTO {

    @JsonProperty("order_number")
    @NotNull(message = "Order number is required")
    private Integer orderNumber;

    @JsonProperty("order_date")
    @NotNull(message = "Order date is required")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate orderDate;

    @Valid
    @JsonProperty("section")
    @NotNull(message = "Section details are required")
    private SectionRequestDTO section;

    @Valid
    @JsonProperty("batch_stock")
    @NotNull(message = "Batch stock details are required")
    private List<BatchStockRequestDTO> batchStock;

}
