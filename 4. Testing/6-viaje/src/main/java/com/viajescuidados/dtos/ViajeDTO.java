package com.viajescuidados.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ViajeDTO {
    @NotEmpty
    private List<Integer> cuidadores;

    @NotBlank
    private UbicacionDTO origen;

    @NotBlank
    private UbicacionDTO destino;
}
