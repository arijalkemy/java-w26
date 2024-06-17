package org.bootcamp.ejerciciodeportistas.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeportePorPersonaDTO {
    private String nombre;
    private String apellido;
    private List<String> deporte;
}
