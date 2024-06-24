package com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.UserDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.util.UserRoles;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RegisterUserDto {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$",
            message = "Password must contain at least one letter and one number")
    private String password;

    private UserRoles rol;

}
