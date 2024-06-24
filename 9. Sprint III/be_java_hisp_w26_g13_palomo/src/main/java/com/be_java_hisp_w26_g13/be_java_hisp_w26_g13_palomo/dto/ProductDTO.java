package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Valid
@Builder
public class ProductDTO {
    @NotNull(message = "La id no puede estar vacia")
    @Positive(message = "el id debe ser mayor a cero")
    @JsonProperty("product_id")
    private int productId;

    @NotBlank(message = "el campo no puede estar vacio")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres")
    @Pattern(regexp="^[A-Za-z0-9\\s]*$", message = "El campo no puede poseer caracteres especiales. ")
    @JsonProperty("product_name")
    private String productName;

    @NotBlank(message = "el campo no puede estar vacio")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp="^[A-Za-z0-9]*$", message = "El campo no puede poseer caracteres especiales. ")
    @JsonProperty("type")
    private String type;

    @NotBlank(message = "el campo no puede estar vacio")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres")
    @Pattern(regexp="^[A-Za-z0-9]*$", message = "El campo no puede poseer caracteres especiales. ")
    @JsonProperty("brand")
    private String brand;

    @NotBlank(message = "el campo no puede estar vacio")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp="^[A-Za-z0-9]*$", message = "El campo no puede poseer caracteres especiales. ")
    @JsonProperty("color")
    private String color;

    @Size(max = 80, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp="^[A-Za-z0-9\\s]*$", message = "El campo no puede poseer caracteres especiales. ")
    @JsonProperty("notes")
    private String notes;
}
