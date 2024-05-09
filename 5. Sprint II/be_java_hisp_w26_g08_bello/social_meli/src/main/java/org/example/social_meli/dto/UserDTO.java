package org.example.social_meli.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    @NotNull(message="El  id no puede estar vacío")
    @Min(value=0, message="El id debe ser mayor a cero")
    private Integer user_id;
    private String user_name;
}
