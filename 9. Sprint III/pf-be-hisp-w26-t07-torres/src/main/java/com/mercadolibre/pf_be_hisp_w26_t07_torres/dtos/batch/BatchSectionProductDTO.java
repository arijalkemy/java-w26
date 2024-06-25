package com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.batch;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
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
public class BatchSectionProductDTO {

    @JsonProperty("batch_number")
    private Integer batchNumber;

    @JsonProperty("current_quantity")
    private Integer currentQuantity;

    @JsonProperty("due_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dueDate;

    @JsonProperty("section")
    private Long sectionCode;

    @JsonProperty("warehouse")
    private Long warehouseCode;

    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("batch_stock")
    private List<BSResponseDTO> batchStock;
}
