package com.group03.sprint2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.group03.sprint2.utils.Constants;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

import static com.group03.sprint2.utils.Constants.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicationDTO implements Serializable {
    @NotNull(message = MSG_VALIDATION_ID_EMPTY)
    @Positive(message = MSG_VALIDATION_ID_POSITIVE)
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("post_id")
    private Integer postId;
    @NotNull(message = MSG_VALIDATION_DATE_EMPTY)
    private LocalDate date;
    @Valid
    private ProductDTO product;
    private Integer category;
    @NotNull(message = MSG_VALIDATION_FIELD_EMPTY)
    @Max(value = 10000000, message = MSG_VALIDATION_PRICE_MAX)
    private Double price;
}
