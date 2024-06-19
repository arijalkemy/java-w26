package com.mercadolibre.sprint_3_team_12_malacara.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.sprint_3_team_12_malacara.enums.Category;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class BatchDueDTO {

    @NotNull
    @NotEmpty
    @Positive
    @JsonProperty("batch_number")
    private Long id;

    @NotNull @NotEmpty @Positive
    @JsonProperty("product_id")
    private Long productId;


    @NotNull @NotEmpty
    @JsonProperty("product_type_id")
    private Category type;

    @NotNull @NotEmpty  @JsonFormat(pattern="dd-MM-yyyy")
    @JsonProperty("due_date")
    private Date dueDate;

    @NotNull @NotEmpty @PositiveOrZero
    @JsonProperty("current_quantity")
    private Integer currentQuantity;

}
