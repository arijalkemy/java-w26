package org.example.social_meli.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class UserDTO {
    @NotNull(message = "El campo no puede ser vacío")
    @Positive(message = "El id debe ser mayor a cero")
    private Integer user_id;
    @Size(max = 15,message = "La longitud maxíma del campo es de 15 carácteres")
    @NotBlank(message = "El campo no puede estar vacío")
    @NotNull(message = "El campo no puede ser nulo")
    private String user_name;
}
