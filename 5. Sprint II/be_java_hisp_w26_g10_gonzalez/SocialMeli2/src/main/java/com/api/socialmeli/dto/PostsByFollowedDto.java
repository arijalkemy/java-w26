package com.api.socialmeli.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostsByFollowedDto {

    @NotNull(message = "El id no puede estar vacío")
    @Min(value = 0, message = "El id debe ser mayor a cero")
    private int user_id;


    private List<@Valid PostDto> posts;
}
