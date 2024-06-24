package com.mercadolibre.final_project_java_hisp_w26_t6.dtos.InboundOrderDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.BatchDto.BatchDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.SectionDto.SectionDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InboundOrderRequestDto implements Serializable {

    @NotNull(message = "El order_number no debe estar vacio")
    @Positive
    @JsonProperty("order_number")
    private Integer orderNumber;

    @NotEmpty(message = "El order_date no debe estar vacio")
    @Pattern(regexp = "([0-2][0-9]|3[0-1])-(0[1-9]|1[0-2])-[0-9]{4}",
            message = "El formato de order_date debe ser dd-mm-yyyy hh:mm:ss")
    @JsonProperty("order_date")
    private String orderDate;

    @Valid
    private SectionDto section;

    @Size(min = 1, message = "Se debe ingresar al menos un batch")
    @JsonProperty("batch_stock")
    @Valid
    private List<BatchDto> batchStock;
}
