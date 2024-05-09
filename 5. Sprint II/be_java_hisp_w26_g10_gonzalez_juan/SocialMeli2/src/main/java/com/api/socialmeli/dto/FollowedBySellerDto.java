package com.api.socialmeli.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowedBySellerDto {

    @NotNull(message = "El id no puede estar vacío")
    @Min(value = 0, message = "El id debe ser mayor a cero")
    private int user_id;

    @NotBlank(message = "El usuario no puede estar vacio")
    @Size(max = 15, message = "El nombre no puede ser mayor a 15 caracteres")
    private String user_name;

    private List<UserDto> followers;
}
