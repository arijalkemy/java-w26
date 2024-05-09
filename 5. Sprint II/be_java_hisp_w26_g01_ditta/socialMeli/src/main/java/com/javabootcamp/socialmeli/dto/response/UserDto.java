package com.javabootcamp.socialmeli.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @JsonProperty("user_id")
    @NotNull(message = "El  id no puede estar vacío.")
    @Min(value = 1,message = "El id debe ser mayor a cero.")
    private Integer id;
    @JsonProperty("user_name")
    @Size(min = 2, max = 15, message = "El user name no debe ser mayor a 15 caracteres")
    private String username;
}
