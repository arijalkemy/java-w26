package com.mercadolibre.sprint_3_valderrama.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
public class ResponseBatchDTO {
    @NotNull
    @NotEmpty
    @Positive
    @JsonProperty("batch_number")
    private Integer idBatch;

    @JsonProperty("current_quantity")
    private Integer currentQuantity;

    @NotNull @NotEmpty  @JsonFormat(pattern="dd-MM-yyyy")
    @JsonProperty("due_date")
    private LocalDate dueDate;
}
