package org.example._08calculadoradecalorias.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Plato {
    private String nombre;
    private Integer peso;
    private List<Ingrediente> ingredientes;
}
