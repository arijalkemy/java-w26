package com.mercadolibre.meli_frescos.dto.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.meli_frescos.model.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {
    private String username;
    private String password;
    @JsonProperty("firstname")
    private String firstName;
    @JsonProperty("lastname")
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Role role;
}
