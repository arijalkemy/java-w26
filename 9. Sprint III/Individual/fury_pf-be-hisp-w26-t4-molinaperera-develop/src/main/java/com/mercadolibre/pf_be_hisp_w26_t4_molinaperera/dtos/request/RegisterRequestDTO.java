package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.request;

import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.model.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
