package com.api.socialmeli.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellersCountFollowersDto {

    @NotNull(message = "El id no puede estar vacío")
    @Min(value = 0, message = "El id debe ser mayor a cero")
    private int user_id;

    @NotBlank(message = "El usuario no puede estar vacio")
    @Size(max = 15, message = "El nombre no puede ser mayor a 15 caracteres")
    private String user_name;

    private int followers_count;
}
