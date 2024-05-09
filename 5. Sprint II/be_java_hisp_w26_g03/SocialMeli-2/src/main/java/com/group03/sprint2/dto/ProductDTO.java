package com.group03.sprint2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;
import static com.group03.sprint2.utils.Constants.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements Serializable {
    @NotNull(message = MSG_VALIDATION_ID_EMPTY)
    @Positive(message = MSG_VALIDATION_ID_POSITIVE)
    @JsonProperty("product_id")
    private Integer productId;
    @NotNull(message = MSG_VALIDATION_FIELD_EMPTY)
    @Size(max = 40, message = MSG_VALIDATION_MAX_CHARACTERS_PRODUCT_NAME)
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = MSG_VALIDATION_SPECIAL_CHARACTERS)
    @JsonProperty("product_name")
    private String productName;
    @NotNull(message = MSG_VALIDATION_FIELD_EMPTY)
    @Size(max = 15, message = MSG_VALIDATION_MAX_CHARACTERS_TYPE)
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = MSG_VALIDATION_SPECIAL_CHARACTERS)
    private String type;
    @NotNull(message = MSG_VALIDATION_FIELD_EMPTY)
    @Size(max = 25, message = MSG_VALIDATION_MAX_CHARACTERS_BRAND)
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = MSG_VALIDATION_SPECIAL_CHARACTERS)
    private String brand;
    @NotNull(message = MSG_VALIDATION_FIELD_EMPTY)
    @Size(max = 15, message = MSG_VALIDATION_MAX_CHARACTERS_COLOR)
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = MSG_VALIDATION_SPECIAL_CHARACTERS)
    private String color;
    @Size(max = 80, message = MSG_VALIDATION_MAX_CHARACTERS_NOTES)
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = MSG_VALIDATION_SPECIAL_CHARACTERS)
    private String notes;
}
