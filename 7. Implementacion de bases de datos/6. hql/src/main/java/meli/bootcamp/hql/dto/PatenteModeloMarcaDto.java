package meli.bootcamp.hql.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatenteModeloMarcaDto {
    private String patente;
    private String modelo;
    private String marca;
}
