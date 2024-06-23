package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class InboundOrderRequestDTO {

    @NotNull(message = "Order number cannot be null")
    @JsonProperty("order_number")
    private Integer orderNumber;

    @NotNull(message = "Order date cannot be null")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonProperty("order_date")
    private LocalDate orderDate;

    @Valid
    @NotNull(message = "Section cannot be null")
    @JsonProperty("section")
    private SectionRequestDTO section;

    @Valid
    @NotNull(message = "Batch stock cannot be null")
    @JsonProperty("batch_stock")
    private BatchRequestDTO batchStock;
}


