package com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.BatchDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BatchTransferDto {
    @NotNull(message = "El batch_number no debe ser null")
    @Positive
    @JsonProperty("batch_number")
    private Integer batchNumber;
}
