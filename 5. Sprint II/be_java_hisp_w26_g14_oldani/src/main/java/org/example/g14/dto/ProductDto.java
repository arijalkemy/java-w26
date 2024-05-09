package org.example.g14.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.g14.utils.ValidationMessages;
import org.example.g14.utils.ValidationUtils;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({ "product_id", "product_name", "type", "brand", "color", "notes" })
public class ProductDto {

    @JsonProperty("product_id")
    @NotNull(message = ValidationMessages.ID_NOT_EMPTY)
    @Positive(message = ValidationMessages.ID_POSITIVE)
    private Integer id;

    @JsonProperty("product_name")
    @NotEmpty(message = ValidationMessages.FIELD_NOT_EMPTY)
    @Size(max = 40, message = ValidationMessages.MAX_LENGTH)
    @Pattern(regexp = ValidationUtils.REGEX_NO_SPECIAL_CHARACTERS, message = ValidationMessages.NO_SPECIAL_CHARACTERS)
    private String name;

    @NotEmpty(message = ValidationMessages.FIELD_NOT_EMPTY)
    @Size(max = 15, message = ValidationMessages.MAX_LENGTH)
    @Pattern(regexp = ValidationUtils.REGEX_NO_SPECIAL_CHARACTERS, message = ValidationMessages.NO_SPECIAL_CHARACTERS)
    private String type;

    @NotEmpty(message = ValidationMessages.FIELD_NOT_EMPTY)
    @Size(max = 25, message = ValidationMessages.MAX_LENGTH)
    @Pattern(regexp = ValidationUtils.REGEX_NO_SPECIAL_CHARACTERS, message = ValidationMessages.NO_SPECIAL_CHARACTERS)
    private String brand;

    @NotEmpty(message = ValidationMessages.FIELD_NOT_EMPTY)
    @Size(max = 15, message = ValidationMessages.MAX_LENGTH)
    @Pattern(regexp = ValidationUtils.REGEX_NO_SPECIAL_CHARACTERS, message = ValidationMessages.NO_SPECIAL_CHARACTERS)
    private String color;

    @Size(max = 80, message = ValidationMessages.MAX_LENGTH)
    @Pattern(regexp = ValidationUtils.REGEX_NO_SPECIAL_CHARACTERS, message = ValidationMessages.NO_SPECIAL_CHARACTERS)
    private String notes;
}
