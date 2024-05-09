package org.example.be_java_hisp_w26_g04.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static org.example.be_java_hisp_w26_g04.util.validation.UtilValidation.REGEX_NO_SPECIAL_CHARS_MESSAGE;
import static org.example.be_java_hisp_w26_g04.util.validation.UtilValidation.REGEX_NO_SPECIAL_CHARS_VALUE;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonPropertyOrder({"productId", "productName", "typeProduct", "brand", "color", "notes"})
public class ProductDTO {
    @Min(value = 1, message = "El id debe ser mayor a cero.")
    @NotNull(message = "El campo no puede estar vacío")
    @JsonAlias("productId")
    @JsonProperty("product_id")
    private Integer productId;

    @NotBlank(message = "El campo no puede estar vacio")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres")
    @Pattern(regexp = REGEX_NO_SPECIAL_CHARS_VALUE, message = REGEX_NO_SPECIAL_CHARS_MESSAGE)
    @JsonAlias("productName")
    @JsonProperty("product_name")
    private String productName;

    @NotBlank(message = "El campo no puede estar vacio")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = REGEX_NO_SPECIAL_CHARS_VALUE, message = REGEX_NO_SPECIAL_CHARS_MESSAGE)
    @JsonAlias("typeProduct")
    @JsonProperty("type")
    private String typeProduct;

    @NotBlank(message = "El campo no puede estar vacio")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres")
    @Pattern(regexp = REGEX_NO_SPECIAL_CHARS_VALUE, message = REGEX_NO_SPECIAL_CHARS_MESSAGE)
    private String brand;

    @NotBlank(message = "El campo no puede estar vacio")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = REGEX_NO_SPECIAL_CHARS_VALUE, message = REGEX_NO_SPECIAL_CHARS_MESSAGE)
    private String color;

    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres")
    @Pattern(regexp = REGEX_NO_SPECIAL_CHARS_VALUE, message = REGEX_NO_SPECIAL_CHARS_MESSAGE)
    private String notes;
}
