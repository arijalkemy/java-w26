package org.covid19.covid19.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Sintoma {
    private String codigo;
    private String nombre;
    private NivelDeGravedad nivel_de_gravedad;

}
