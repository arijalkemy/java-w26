package com.mercadolibre.project_be_java_hisp_w26_team4.dtos.request;

import com.mercadolibre.project_be_java_hisp_w26_team4.model.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequestDTO {
    @NotBlank(message = "Username cannot be empty")
    private String username;
    @NotBlank(message = "Password cannot be empty")
    private String password;
    @NotNull(message = "Role cannot be null")
    //@Pattern( regexp = "(BUYER|SELLER)", message = "Role must be BUYER or SELLER")
    private Role role;

}
