package org.example.tiendadeprendas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PrendaDto {
    String nombre;
    String marca;
    String color;
    String talla;
    Integer cantidad;
    Double precio;
}
