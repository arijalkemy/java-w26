package com.example.elasticsearchempleadoproducto.dto;

import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmpleadoDto implements Serializable {

        @NotBlank
        private String name;
        @NotBlank
        private String lastName;

        @NotNull
        private Integer edad;

        @NotBlank
        private String ciudad;

        @NotBlank
        private String provincia;
    }

