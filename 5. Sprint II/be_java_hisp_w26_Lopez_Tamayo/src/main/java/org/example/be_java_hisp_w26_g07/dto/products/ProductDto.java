package org.example.be_java_hisp_w26_g07.dto.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class ProductDto {
    @NotNull(message = "El id no puede estar vacío.")
    @Positive(message = "El id debe ser mayor a cero")
    @JsonProperty("product_id")
    private Integer id;

    @Pattern(
            regexp = "^[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$",
            message = "El campo no puede poseer caracteres especiales."
    )
    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @JsonProperty("product_name")
    private String name;

    @Pattern(
            regexp = "^[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$",
            message = "El campo no puede poseer caracteres especiales."
    )
    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @JsonProperty("type")
    private String type;

    @Pattern(
            regexp = "^[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$",
            message = "El campo no puede poseer caracteres especiales."
    )
    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
    @JsonProperty("brand")
    private String brand;

    @Pattern(
            regexp = "^[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$",
            message = "El campo no puede poseer caracteres especiales."
    )
    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @JsonProperty("color")
    private String color;

    @Pattern(
            regexp = "^[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$",
            message = "El campo no puede poseer caracteres especiales."
    )
    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
    @JsonProperty("notes")
    private String notes;
}
