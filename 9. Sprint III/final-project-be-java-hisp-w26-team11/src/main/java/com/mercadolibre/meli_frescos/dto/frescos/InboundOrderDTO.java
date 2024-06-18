package com.mercadolibre.meli_frescos.dto.frescos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class InboundOrderDTO {
    @NotNull(message = "Order number cannot be null")
    @Positive(message = "Order number must be positive")
    @JsonProperty("order_number")
    private Integer orderNumber;
    @NotNull(message = "Order date cannot be null")
    @JsonProperty("order_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate orderDate;
    @Valid
    @NotNull(message = "Section cannot be null")
    private SectionDTO section;
    @Valid
    @NotNull(message = "Batch stock cannot be null")
    @JsonProperty("batch_stock")
    private List<BatchStockRequestDTO> batchStock;
}
