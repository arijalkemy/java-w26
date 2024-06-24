package com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.BatchDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.util.StorageType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude( JsonInclude.Include.NON_NULL )
public class BatchStockDto implements Serializable {

    @NotNull(message = "El batch_number no debe ser null")
    @Positive
    @JsonProperty("batch_number")
    private Integer batchNumber;

    @NotNull(message = "El current_quantity no debe ser null")
    @JsonProperty("current_quantity")
    @Positive
    private Integer currentQuantity;

    @NotBlank(message = "El due_date no debe estar vacio")
    @JsonProperty("due_date")
    private String due_date;

    @NotNull(message = "El product_id no debe estar vacio")
    @Positive
    @JsonProperty("product_id")
    private Integer productId;

    @NotNull(message = "El product_type no debe estar vacio")
    @Positive
    @JsonProperty("product_type")
    private StorageType productType;
}
