package org.covid19.covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.covid19.covid19.entidades.NivelDeGravedad;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SintomaDto {
    private String nombre;
     private String nivel_de_gravedad;
}
