package co.com.mercadolibre.covid.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sintoma {

    private String codigo;
    private String nombre;
    private String nivelDeGravedad;
}
