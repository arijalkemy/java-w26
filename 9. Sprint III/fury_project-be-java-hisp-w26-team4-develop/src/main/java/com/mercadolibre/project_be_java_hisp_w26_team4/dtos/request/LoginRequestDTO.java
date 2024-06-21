package com.mercadolibre.project_be_java_hisp_w26_team4.dtos.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequestDTO {
    @NotNull(message = "Username cannot be null")
    @Size(min = 5, max = 30, message = "The size of the characters must be between {min} and {max}")
    private String username;
    @NotNull(message = "Password cannot be null")
    private String password;
}
